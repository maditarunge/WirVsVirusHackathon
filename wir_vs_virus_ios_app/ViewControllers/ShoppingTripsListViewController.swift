//
//  ShoppingTripsListViewController.swift
//  wir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin  on 21.03.20.
//  Copyright © 2020 Fischer, Benjamin  All rights reserved.
//

import UIKit

class ShoppingTripsListViewController: UIViewController {
    
    // MARK: IBOutlet properties
    @IBOutlet weak var tableView: UITableView!
    
    // MARK: properties
    var trips:[ShoppingTrip]!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
        trips = setupDummyTrips()
        
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
    private func setupDummyTrips() -> [ShoppingTrip] {
        var trips = [ShoppingTrip]()
        var trip1 = ShoppingTrip()
        trip1.coordinate = Coordinate(latitude: 52.522617, longitude: 13.413891)
        trip1.date = "2020-03-24 10:01:52.173"
        trip1.id = 1
        trip1.shopper = User.createDummyUser()
        trip1.title = "Edeka Einkauf"
        trips.append(trip1)
        
        var trip2 = ShoppingTrip()
        trip2.coordinate = Coordinate(latitude: 52.522617, longitude: 13.413891)
        trip2.date = "2020-03-28 10:01:52.173"
        trip2.id = 2
        trip2.shopper = User.createDummyUser()
        trip2.title = "REWE Einkauf"
        trips.append(trip2)
        return trips
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // TODO hier dann die einzelsicht vorbereiten
    }
}

extension ShoppingTripsListViewController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return trips.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: Constants.CellIdentifier.shoppingTripCell) as! ShoppingTripCell
        let trip = trips[indexPath.row]
        cell.setupCell(tripInp: trip)
        cell.selectionStyle = .none
        return cell
        
    }
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let view = UIView();
        view.backgroundColor = Constants.shoppingColor
        view.clipsToBounds = true
        view.layer.cornerRadius = 50
        view.layer.maskedCorners = [.layerMinXMaxYCorner]
        
        // creating the header label
        let headerLabel = UILabel()
        headerLabel.text = "Anstehende Einkäufe"
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
        infoLabel.text = "Hier bekommst du eine Übersicht über alle anstehenden Einkäufe in deiner Nachbarschaft"
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
        createTripButton.setTitle("Einkauf anlegen", for: .normal)
        createTripButton.backgroundColor = UIColor().hexStringToUIColor(hex: "#FF4646")
        createTripButton.translatesAutoresizingMaskIntoConstraints = false
        createTripButton.makeButtonRound(radius: 10, borderWidth: 1, borderColor: .clear)
        // adding the create trip button
        view.addSubview(createTripButton)
        // configuring the create trips constraints
        createTripButton.topAnchor.constraint(equalTo: infoLabel.bottomAnchor, constant: 25).isActive = true
        createTripButton.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 25).isActive = true
        
        return view
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return section == 0 ? 300 : 1.0
    }
}

