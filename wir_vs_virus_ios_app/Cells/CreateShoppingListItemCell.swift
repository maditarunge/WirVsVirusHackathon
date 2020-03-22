//
//  CreateShoppingListItemCell.swift
//  wir_vs_virus_ios_appir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin (polidia) on 22.03.20.
//  Copyright © 2020 Fischer, Benjamin (polidia). All rights reserved.
//

import UIKit

class CreateShoppingListItemCell: UITableViewCell {
    
    // MARK: properties
    var listItem:GroceryListItem?
    var itemTitleLabel:UILabel!
    var itemMetaLabel:UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
    
    override func prepareForReuse() {
        if itemTitleLabel != nil {
            itemTitleLabel.text = nil
        }
        if itemMetaLabel != nil {
            itemMetaLabel.text = nil
        }
    }
    
    func setupCell(itemInp: GroceryListItem) {
        
        self.listItem = itemInp
        
        // create, configure and add the date label
        itemTitleLabel = UILabel()
        itemTitleLabel.numberOfLines = 0
        itemTitleLabel.font = UIFont.preferredFont(forTextStyle: .body).bold()
        itemTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        itemTitleLabel.text = self.listItem!.title!
        contentView.addSubview(itemTitleLabel)
        // setting up the date labels constraints
        itemTitleLabel.topAnchor.constraint(equalTo: contentView.topAnchor, constant: 5).isActive = true
        itemTitleLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 5).isActive = true
        itemTitleLabel.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -5).isActive = true
        
        itemMetaLabel = UILabel()
        itemMetaLabel.numberOfLines = 0
        itemMetaLabel.font = UIFont.preferredFont(forTextStyle: .body)
        itemMetaLabel.translatesAutoresizingMaskIntoConstraints = false
        var metaString = ""
        if listItem!.bio! {
            metaString.append("Bio: Ja")
        } else {
             metaString.append("Bio: Nein")
        }
        metaString.append(", ")
        if listItem!.glutenFree! {
             metaString.append("Glutenfrei: Ja")
        } else {
             metaString.append("Glutenfrei: Nein")
        }
        itemMetaLabel.text = metaString
        contentView.addSubview(itemMetaLabel)
        // setting up the date labels constraints
        itemMetaLabel.topAnchor.constraint(equalTo: itemTitleLabel.bottomAnchor, constant: 5).isActive = true
        itemMetaLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 5).isActive = true
        itemMetaLabel.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -5).isActive = true
        itemMetaLabel.bottomAnchor.constraint(equalTo: contentView.bottomAnchor, constant: -5).isActive = true
    }
    
}
