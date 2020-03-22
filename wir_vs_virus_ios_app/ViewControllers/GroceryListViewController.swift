//
//  GroceryListViewController.swift
//  wir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin  on 21.03.20.
//  Copyright © 2020 Fischer, Benjamin . All rights reserved.
//

import UIKit

class GroceryListViewController: UIViewController {
    
    // MARK: IBOutlet properties
    @IBOutlet weak var tableView: UITableView!
    
    // MARK: properties
    var lists:[GroceryList]!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        lists = setupDummyLists()
        
        tableView.delegate = self
        tableView.dataSource = self
        tableView.separatorStyle = .none
        
        // configuring the table view
        tableView.estimatedRowHeight = 200
        tableView.rowHeight = UITableView.automaticDimension
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
        // dispose any resources that can be restored
    }
    
    // MARK: private functions
    private func setupDummyLists() -> [GroceryList] {
        var lists = [GroceryList]()
        var items = [GroceryListItem]()
        
        var listItem = GroceryListItem()
        listItem.title = "Spaghetti"
        listItem.bio = false
        listItem.glutenFree = false
        items.append(listItem)
        
        var list1 = GroceryList()
        list1.id = 1
        list1.receiver = User.createDummyUser()
        list1.title = "Lidl Einkauf"
        list1.items = items
        lists.append(list1)
        
        return lists
    }
    
    // some segue preparations for the detail view
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        guard tableView.indexPathForSelectedRow != nil else {
            return
        }
        if segue.identifier == Constants.Segues.showListeItemDetailSeque {
            let vc = segue.destination as! GroceryListDetailViewController
            
            vc.groceryList = lists[tableView.indexPathForSelectedRow!.row]
            
        }
    }
    
}

extension GroceryListViewController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return lists.count
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        // trigger the segue to the detail view controller
        self.performSegue(withIdentifier: Constants.Segues.showListeItemDetailSeque, sender: self)
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: Constants.CellIdentifier.groceryListView) as! GroceryListCell
        let list = lists[indexPath.row]
        cell.setupCell(groceryListInp: list)
        cell.selectionStyle = .none
        return cell
    }
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let view = UIView();
        view.backgroundColor = Constants.groceryColor
        view.clipsToBounds = true
        view.layer.cornerRadius = 50
        view.layer.maskedCorners = [.layerMinXMaxYCorner]
        
        // creating the header label
        let headerLabel = UILabel()
        headerLabel.text = "Benötigte Einkäufe"
        headerLabel.numberOfLines = 0
        headerLabel.translatesAutoresizingMaskIntoConstraints = false
        headerLabel.font = UIFont.preferredFont(forTextStyle: .title1)
        headerLabel.textColor = .white
        // adding the header label
        view.addSubview(headerLabel)
        // configuring the header labels constraints
        headerLabel.topAnchor.constraint(equalTo: view.topAnchor, constant: 25).isActive = true
        headerLabel.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 25).isActive = true
        headerLabel.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -25).isActive = true
        
        // creating the header label
        let infoLabel = UILabel()
        infoLabel.text = "Hier siehst du eine Liste der benötigten Einkäufe in deiner Nachbarschaft"
        infoLabel.numberOfLines = 0
        infoLabel.translatesAutoresizingMaskIntoConstraints = false
        infoLabel.font = UIFont.preferredFont(forTextStyle: .body)
        infoLabel.textColor = .white
        // addding the info label
        view.addSubview(infoLabel)
        // configuring the info labels constraints
        infoLabel.topAnchor.constraint(equalTo: headerLabel.bottomAnchor, constant: 15).isActive = true
        infoLabel.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 25).isActive = true
        infoLabel.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -25).isActive = true
        
        // creating the create trip button
        let createTripButton = UIButton();
        createTripButton.setTitle("Liste anlegen", for: .normal)
        createTripButton.backgroundColor = UIColor().hexStringToUIColor(hex: "#FF4646")
        createTripButton.translatesAutoresizingMaskIntoConstraints = false
        createTripButton.makeButtonRound(radius: 10, borderWidth: 1, borderColor: .clear)
        createTripButton.addTarget(self, action: #selector(createListButtonTapped), for: .touchUpInside)
        // adding the create trip button
        view.addSubview(createTripButton)
        // configuring the create trips constraints
        createTripButton.topAnchor.constraint(equalTo: infoLabel.bottomAnchor, constant: 25).isActive = true
        createTripButton.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 25).isActive = true
        
        return view
    }
    
    @objc func createListButtonTapped() {
        // createListVC
        let createListVC = storyboard?.instantiateViewController(withIdentifier: Constants.Storyboard.createListVC) as! CreateGroceryListViewController
        createListVC.createListButtonDelegate = self
        createListVC.modalPresentationStyle = .fullScreen
        present(createListVC, animated: true, completion:nil)
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return section == 0 ? 300 : 1.0
    }
    
}

extension GroceryListViewController: CreateListButtonDelegate {
    
    func createListTapped(_ list: GroceryList) {
        lists.append(list)
        tableView.reloadData()
    }
    
    
}
