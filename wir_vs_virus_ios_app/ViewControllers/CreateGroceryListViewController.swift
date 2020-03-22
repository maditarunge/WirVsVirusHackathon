//
//  CreateGroceryListViewController.swift
//  wir_vs_virus_ios_appir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin (polidia) on 22.03.20.
//  Copyright © 2020 Fischer, Benjamin (polidia). All rights reserved.
//

import UIKit

class CreateGroceryListViewController: UIViewController {
    
    // MARK: IBOutlet properties
    @IBOutlet weak var infoView: UIView!
    @IBOutlet weak var infoHeader: UILabel!
    @IBOutlet weak var infoLabel: UILabel!
    @IBOutlet weak var storeNameField: UITextField!
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var saveListButton: UIButton!
    
    @IBOutlet weak var addItemButton: UIButton!
    // MARK: properties
    var listItems = [GroceryListItem]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tableView.delegate = self
        tableView.dataSource = self
        tableView.separatorStyle = .none
        
        // configuring the table view
        tableView.estimatedRowHeight = 200
        tableView.rowHeight = UITableView.automaticDimension
        
        setupView()
    }
    
    private func setupView() {
        
        infoView.backgroundColor = Constants.shoppingColor
        infoView.clipsToBounds = true
        infoView.layer.cornerRadius = 50
        infoView.layer.maskedCorners = [.layerMinXMaxYCorner]
        infoHeader.text = "Neue Liste anlegen"
        infoHeader.textColor = .white
        
        infoLabel.text = "Hier steht dann ein längerer Infotext Hier steht dann ein längerer Infotext Hier steht dann ein längerer Infotext Hier steht dann ein längerer Infotext Hier steht dann ein längerer Infotext Hier steht dann ein längerer Infotext Hier steht dann ein längerer Infotext"
        infoLabel.textColor = .white
        
        let boldAttribute = [NSAttributedString.Key.font: UIFont.preferredFont(forTextStyle: .body).bold()]
         let storePlaceHolder = NSMutableAttributedString(string: "Name des Martktes", attributes: boldAttribute)
        storeNameField.attributedPlaceholder = storePlaceHolder
        
        addItemButton.setTitle("Eintrag hinzufügen", for: .normal)
        addItemButton.makeButtonRound(radius: 10, borderWidth: 1, borderColor: .clear)
        addItemButton.addTarget(self, action: #selector(addItemTapped), for: .touchUpInside)
                
        saveListButton.setTitle("Liste abspeichern", for: .normal)
        saveListButton.makeButtonRound(radius: 10, borderWidth: 1, borderColor: .clear)
        saveListButton.addTarget(self, action: #selector(saveListTapped), for: .touchUpInside)
        
        
    }
    
    @objc func saveListTapped() {
        print("speichern")
    }
    
    @objc func addItemTapped() {
        let addItemVC = storyboard?.instantiateViewController(withIdentifier: Constants.Storyboard.addItemVC) as! CreateListItemViewController
        addItemVC.createListButtonDelegate = self
        addItemVC.modalPresentationStyle = .fullScreen
        present(addItemVC, animated: true, completion:nil)
    }
    
}

extension CreateGroceryListViewController: UITableViewDataSource, UITableViewDelegate {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return listItems.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: Constants.CellIdentifier.createShoppingListItemCell) as! CreateShoppingListItemCell
        let item = listItems[indexPath.row]
        cell.setupCell(itemInp: item)
        
        return cell
        
    }
    
}

extension CreateGroceryListViewController: CreateListItemButtonDelegate {
    func addButtonTapped(_ item: GroceryListItem) {
        listItems.append(item)
        tableView.reloadData()
    }
    
    
}
