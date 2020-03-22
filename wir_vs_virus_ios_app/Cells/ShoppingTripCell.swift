//
//  ShoppingTripCell.swift
//  wir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin  on 21.03.20.
//  Copyright © 2020 Fischer, Benjamin . All rights reserved.
//

import UIKit

class ShoppingTripCell: UITableViewCell {
    
    // MARK: IBOutlet properties
    @IBOutlet weak var cellView: UIView!
    @IBOutlet weak var dateLabel: UILabel!
    @IBOutlet weak var shoppingTripLabel: UILabel!
    
    // MARK: properties
    var shoppingTrip: ShoppingTrip?
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    override func prepareForReuse() {
        if dateLabel != nil {
            dateLabel.text = nil
        }
        
        if shoppingTripLabel != nil {
            shoppingTripLabel.text = nil
        }
    }

    // MARK: functions
    /**
     setting up the cell
     */
    func setupCell(tripInp: ShoppingTrip) {
        shoppingTrip = tripInp
        
        cellView.makeRound(radius: 10, borderWidth: 0.25, borderColor: .black)
        
        let boldAttribute = [NSAttributedString.Key.font: UIFont.preferredFont(forTextStyle: .body).bold()]
        let shoppingDate = Date.convertStringToDate(fromString: shoppingTrip!.date!)
        let shoppingDayNumber = shoppingDate.getFormattedDateString(dateFormat: "dd")
        let shoppingDayString = shoppingDate.getFormattedDateString(dateFormat: "E")
        
        let shoppingDateString = NSMutableAttributedString(string: "\(shoppingDayNumber)\n", attributes: boldAttribute)
        let shoppingWeekDayString = NSAttributedString(string: shoppingDayString)
        shoppingDateString.append(shoppingWeekDayString)
        dateLabel.attributedText = shoppingDateString
        dateLabel.numberOfLines = 0
        
        let shoppingTripString = NSMutableAttributedString(string: "\(shoppingTrip!.title!)\n", attributes: boldAttribute)
        let shoppingTripAuthorString = NSAttributedString(string: shoppingTrip!.shopper!.firstname!)
        shoppingTripString.append(shoppingTripAuthorString)
        shoppingTripLabel.attributedText = shoppingTripString
        shoppingTripLabel.numberOfLines = 0
    }
}
