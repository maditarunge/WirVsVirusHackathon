//
//  GroceryListDetailViewController.swift
//  wir_vs_virus_ios_appir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin (polidia) on 22.03.20.
//  Copyright © 2020 Fischer, Benjamin (polidia). All rights reserved.
//

import UIKit

class GroceryListDetailViewController: UIViewController {
    
    // MARK: IBoutlet properties
    
    @IBOutlet weak var groceryListViewInfoSection: UIView!
    @IBOutlet weak var receiverImageView: UIImageView!
    @IBOutlet weak var receiverInfoLabel: UILabel!
    
    @IBOutlet weak var tableView: UITableView!
    
    @IBOutlet weak var acceptButton: UIButton!
    
    @IBOutlet weak var backButton: UIButton!
    // MARK: properties
    var groceryList: GroceryList?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tableView.delegate = self
        tableView.dataSource = self
        tableView.separatorStyle = .none
        
        // configuring the table view
        tableView.estimatedRowHeight = 200
        tableView.rowHeight = UITableView.automaticDimension
        
        setupViews()
    }
    
    private func setupViews() {
        let boldAttribute = [NSAttributedString.Key.font: UIFont.preferredFont(forTextStyle: .body).bold()]
        
        receiverImageView.backgroundColor = Constants.groceryColor
        receiverImageView.layer.cornerRadius = receiverImageView.frame.size.width / 2
        receiverImageView.clipsToBounds = true
        
        let groceryListString = NSMutableAttributedString(string: "\(groceryList!.title!)\n", attributes: boldAttribute)
        let groceryListReceiverString = NSAttributedString(string: groceryList!.receiver!.firstname!)
        groceryListString.append(groceryListReceiverString)
        receiverInfoLabel.attributedText = groceryListString
        receiverInfoLabel.numberOfLines = 0
        
        
        acceptButton.setTitle("Einkauf übernehmen", for: .normal)
        acceptButton.makeButtonRound(radius: 10, borderWidth: 1, borderColor: .clear)
        
        backButton.setTitle("Zurück", for: .normal)
        backButton.makeButtonRound(radius: 10, borderWidth: 1, borderColor: .clear)
    }
    
    
    @IBAction func acceptButtonTapped(_ sender: Any) {
        print("Akzeptiert")
    }
    
    @IBAction func backButtonTapped(_ sender: Any) {
        dismiss(animated: true, completion: nil)
    }
}


extension GroceryListDetailViewController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return groceryList!.items!.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        // TODO change in own cell
        let cell = tableView.dequeueReusableCell(withIdentifier: Constants.CellIdentifier.createShoppingListItemCell) as! CreateShoppingListItemCell
        
        let items = groceryList!.items!
        let item = items[indexPath.row]
        cell.setupCell(itemInp: item)
        return cell
        
    }
    
    
    
    
}
