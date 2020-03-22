//
//  CreateListItemViewController.swift
//  wir_vs_virus_ios_appir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin (polidia) on 22.03.20.
//  Copyright © 2020 Fischer, Benjamin (polidia). All rights reserved.
//

import UIKit

protocol CreateListItemButtonDelegate {
    func addButtonTapped(_ item:GroceryListItem)
}

class CreateListItemViewController: UIViewController {
    
    // MARK: IBOutlet properties
    
    @IBOutlet weak var headerLabel: UILabel!
    @IBOutlet weak var itemTextField: UITextField!
    @IBOutlet weak var saveButton: UIButton!
    @IBOutlet weak var cancelButton: UIButton!
    
    @IBOutlet weak var bioView: UIView!
    @IBOutlet weak var bioLabel: UILabel!
    @IBOutlet weak var bioSwitch: UISwitch!
    
    @IBOutlet weak var glutenView: UIView!
    @IBOutlet weak var glutenLabel: UILabel!
    @IBOutlet weak var glutenSwitch: UISwitch!
    
    
    // MARK: properties
    var createListButtonDelegate: CreateListItemButtonDelegate!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        setupView()
    }
    
    
    private func setupView() {
        headerLabel.text = "Neuen Eintrag erstellen"
        let boldAttribute = [NSAttributedString.Key.font: UIFont.preferredFont(forTextStyle: .body).bold()]
        let itemDescriptionString = NSMutableAttributedString(string: "Artikel", attributes: boldAttribute)
        itemTextField.attributedPlaceholder = itemDescriptionString
        itemTextField.delegate = self
        
        bioLabel.text = "Bio?"
        bioSwitch.isOn = false
        
        glutenLabel.text = "Glutenfrei?"
        glutenSwitch.isOn = false
        
        saveButton.setTitle("Eintrag hinzufügen", for: .normal)
        saveButton.makeButtonRound(radius: 10, borderWidth: 1, borderColor: .clear)
        saveButton.addTarget(self, action: #selector(addItemTapped), for: .touchUpInside)
        
        cancelButton.setTitle("Abbrechen", for: .normal)
        cancelButton.makeButtonRound(radius: 10, borderWidth: 1, borderColor: .clear)
        cancelButton.addTarget(self, action: #selector(cancelTapped), for: .touchUpInside)
    }

    @objc func addItemTapped() {
         if self.createListButtonDelegate != nil {
            dismiss(animated: true) {
                var newItem = GroceryListItem()
                newItem.title = self.itemTextField.text
                newItem.bio = self.bioSwitch.isOn
                newItem.glutenFree = self.glutenSwitch.isOn
                self.createListButtonDelegate.addButtonTapped(newItem)
            }
       }
    }
    
    @objc func cancelTapped() {
        dismiss(animated: true, completion: nil)
    }

}


extension CreateListItemViewController: UITextFieldDelegate {
    
}

