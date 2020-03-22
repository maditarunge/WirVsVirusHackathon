//
//  GroceryListCell.swift
//  wir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin on 21.03.20.
//  Copyright © 2020 Fischer, Benjamin. All rights reserved.
//

import UIKit

class GroceryListCell: UITableViewCell {
    
    // MARK: IBoutlet Properties
    @IBOutlet weak var cellView: UIView!
    @IBOutlet weak var shooperImageView: UIImageView!
    @IBOutlet weak var groceryListInfoLabel: UILabel!
    
    // MARK: properties
    var groceryList: GroceryList?
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
    
    override func prepareForReuse() {
        if groceryListInfoLabel != nil {
            groceryListInfoLabel.text = nil
        }
    }
    
    /**
     setting up the cell
     */
    func setupCell(groceryListInp: GroceryList) {
        
        groceryList = groceryListInp
        let boldAttribute = [NSAttributedString.Key.font: UIFont.preferredFont(forTextStyle: .body).bold()]
        
        shooperImageView.backgroundColor = Constants.groceryColor
        shooperImageView.layer.cornerRadius = shooperImageView.frame.size.width / 2
        shooperImageView.clipsToBounds = true
        
        let groceryListString = NSMutableAttributedString(string: "\(groceryList!.title!)\n", attributes: boldAttribute)
        let groceryListReceiverString = NSAttributedString(string: groceryList!.receiver!.firstname!)
        groceryListString.append(groceryListReceiverString)
        groceryListInfoLabel.attributedText = groceryListString
        groceryListInfoLabel.numberOfLines = 0
    }
    
}
