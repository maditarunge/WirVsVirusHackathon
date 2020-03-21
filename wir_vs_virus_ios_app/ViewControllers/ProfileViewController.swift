//
//  ProfileViewController.swift
//  wir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin (polidia) on 21.03.20.
//  Copyright © 2020 Fischer, Benjamin (polidia). All rights reserved.
//

import UIKit

class ProfileViewController: UIViewController {
    
    // MARK: IBoutlet properties
    @IBOutlet weak var userImageView: UIImageView!
    
    @IBOutlet weak var userProfileView: UIView!
    
    @IBOutlet weak var userNameLabel: UILabel!
    @IBOutlet weak var shoppingTripsImageView: UIImageView!
    @IBOutlet weak var shoppingTripsInfoLabel: UILabel!
    @IBOutlet weak var groceryListImageView: UIImageView!
    @IBOutlet weak var groceryListInfoLabel: UILabel!
    @IBOutlet weak var groceryListSection: UIView!
    
    @IBOutlet weak var shoppingTripsSection: UIView!
    // MARK: properties
    let user = User.createDummyUser()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
        
        // setting up the views
        setupViews()
        
        // setting up the labels
        setupLabels()
        
        // setting up the images
        setupImages()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
        // dispose any resources that can be restored
    }
    
    
    // MARK: private functions
    /**
     Setting up all the labels
     */
    private func setupLabels() {
        let boldAttribute = [NSAttributedString.Key.font: UIFont.preferredFont(forTextStyle: .body).bold()]
        let userNameString = NSMutableAttributedString(string: "\(user.firstname!) \(user.name!)\n", attributes: boldAttribute)
        let userLocationString = NSAttributedString(string: "aus \(user.city!)")
        userNameString.append(userLocationString)
        userNameLabel.attributedText = userNameString
        
        let shoppingTripsString = NSMutableAttributedString(string: "Shopping Trips\n", attributes: boldAttribute)
        let nextShoppingDateString = NSAttributedString(string: "nächster Trip: 01.04")
        shoppingTripsString.append(nextShoppingDateString)
        shoppingTripsInfoLabel.attributedText = shoppingTripsString
        
        let groceryListString = NSMutableAttributedString(string: "Deine Liste\n", attributes: boldAttribute)
        let openListStrings = NSAttributedString(string: "5 offene Listen")
        groceryListString.append(openListStrings)
        groceryListInfoLabel.attributedText = groceryListString
    }
    
    /**
     setting up the views
     */
    private func setupViews() {
        userProfileView.makeRound(radius: 10, borderWidth: 0.25, borderColor: .black)
        shoppingTripsSection.makeRound(radius: 10, borderWidth: 0.25, borderColor: .black)
        groceryListSection.makeRound(radius: 10, borderWidth: 0.25, borderColor: .black)
    }
    
    /**
     setting up the images
     */
    private func setupImages() {
        let userImage = UIImage(named: "profile")
        userImageView.image = userImage
        userImageView.backgroundColor = Constants.shoppingColor
        self.userImageView.layer.cornerRadius = self.userImageView.frame.size.width / 2
        self.userImageView.clipsToBounds = true
        
        let shoppingTripImage = UIImage(named: "shopping_bag_black")
        shoppingTripsImageView.image = shoppingTripImage
        
        let groceryListImage = UIImage(named: "grocery_list_black")
        groceryListImageView.image = groceryListImage
    }
    
    
}
