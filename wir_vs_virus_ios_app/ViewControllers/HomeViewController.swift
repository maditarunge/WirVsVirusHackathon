//
//  HomeViewController.swift
//  wir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin on 21.03.20.
//  Copyright © 2020 Fischer, Benjamin. All rights reserved.
//

import UIKit
import MapKit
import CoreLocation

class HomeViewController: UIViewController {
    
    // MARK: IBOutlet properties
    @IBOutlet weak var headerLabel: UILabel!
    @IBOutlet weak var mapView: MKMapView!
    @IBOutlet weak var shoppingButton: UIButton!
    @IBOutlet weak var groceryListButton: UIButton!
    @IBOutlet weak var subheaderLabel: UILabel!
    @IBOutlet weak var infoLabel: UILabel!
    
    // MARK: properties
    let locationManager:CLLocationManager = CLLocationManager()
    var lastKnowLocation:CLLocation?
    var user = User.createDummyUser()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // setting up the labels
        setupLabels()
        
        // setting up the buttons
        setupButtons()
        
        // setting up the map
        setupMap()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
        // dispose any resources that can be restored
    }
    
    // MARK: private functions
    /**
     This function handles all the label setup stuff
     */
    private func setupLabels() {
        headerLabel.text = "Willkommen zurück, \(user.firstname!)"
        subheaderLabel.text = "Bleibe sicher vernetzt"
        infoLabel.text = "Hier findest du Menschen in deiner Nähe mit denen du dich vernetzen kannst"
    }
    
    /**
     This functions handles all the button setup stuff
     */
    private func setupButtons() {
        shoppingButton.backgroundColor = Constants.shoppingColor
        shoppingButton.imageEdgeInsets = UIEdgeInsets(top: 25, left: 25, bottom: 25, right: 25)
        shoppingButton.makeButtonRound(radius: 10, borderWidth: 2, borderColor: .clear)
        groceryListButton.backgroundColor = Constants.groceryColor
        groceryListButton.imageEdgeInsets = UIEdgeInsets(top: 25, left: 25, bottom: 25, right: 25)
        groceryListButton.makeButtonRound(radius: 10, borderWidth: 2, borderColor: .clear)
    }
    
    /**
     This function handles all the map setup stuff
     */
    private func setupMap() {
        // Auto lcoate when opening the view
        //        self.locationManager.requestWhenInUseAuthorization()
        //
        //        if CLLocationManager.locationServicesEnabled() {
        //            locationManager.delegate = self
        //            locationManager.desiredAccuracy = kCLLocationAccuracyBest
        //            locationManager.startUpdatingLocation()
        //        }
        
        mapView.delegate = self
        mapView.mapType = .standard
        mapView.isZoomEnabled = true
        mapView.isScrollEnabled = true
        
        // auto locate center
        //        if let coor = mapView.userLocation.location?.coordinate{
        //            mapView.setCenter(coor, animated: true)
        //        }
        var alex = CLLocationCoordinate2D()
        alex.latitude = CLLocationDegrees(exactly: 52.521918)!
        alex.longitude = CLLocationDegrees(exactly: 13.413215)!
        mapView.setCenter(alex, animated: true)
        let region = MKCoordinateRegion(center: alex, latitudinalMeters: 500, longitudinalMeters: 500)
        self.mapView.setRegion(region, animated: true)
        setupDummyPins()
    }
    
    /**
     tmp functiion to add some dummy example pins to the app
     */
    private func setupDummyPins() {
        // 52.522617,
        let annotation1 = MKPointAnnotation()
        annotation1.coordinate = CLLocationCoordinate2D(latitude: 52.522617, longitude: 13.413891)
        mapView.addAnnotation(annotation1)
        
        // 52.520175, 13.410554
        let annotation2 = MKPointAnnotation()
        annotation2.coordinate = CLLocationCoordinate2D(latitude: 52.520175, longitude: 13.41055)
        mapView.addAnnotation(annotation2)
    }
    
    // MARK: functions
    /**
     Handles the tap on the shopping list button
     */
    @IBAction func shoppingListButtonTapped(_ sender: UIButton) {
        
        // TODO absichern
        let appDelegate  = UIApplication.shared.delegate as! AppDelegate
        let tabBarController = appDelegate.window!.rootViewController as! UITabBarController
        tabBarController.selectedIndex = 1
        
    }
    
    /**
     Handles the tap on the grocery list button
     */
    @IBAction func groceryListButtonTapped(_ sender: UIButton) {
        
        // TODO absichern
        let appDelegate  = UIApplication.shared.delegate as! AppDelegate
        let tabBarController = appDelegate.window!.rootViewController as! UITabBarController
        tabBarController.selectedIndex = 2
    }
}

extension HomeViewController: MKMapViewDelegate {
    // TODO prüfen ob notwendig als eigene extensions
}

extension HomeViewController: CLLocationManagerDelegate {
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        
        if let location = locations.last{
            let center = CLLocationCoordinate2D(latitude: location.coordinate.latitude, longitude: location.coordinate.longitude)
            let region = MKCoordinateRegion(center: center, span: MKCoordinateSpan(latitudeDelta: 0.01, longitudeDelta: 0.01))
            self.mapView.setRegion(region, animated: true)
        }
        
    }
    
    
    func locationManager(_ manager: CLLocationManager, didChangeAuthorization status: CLAuthorizationStatus) {
        
        if status == .denied || status == .restricted {
            
            // user choose don't allow
            showGeolocationError()
        }else if status == .authorizedAlways || status == .authorizedWhenInUse{
            
            // start locatie the user
            locationManager.startUpdatingLocation()
            
        }
        
    }
    
    /**
     Method will create and show an alert if the geo location service is disabled
     */
    private func showGeolocationError() {
        
        // create the alert
        let alert = UIAlertController(title: "Standort konnte nicht bestimmt werden", message: "Der aktuelle Standort konnte nicht bestimmt werden da die App keinen Zugriff hat. Bitte erlaube den Zugriff auf die Standortermittlung", preferredStyle: .alert)
        
        // create the settings button
        let settingsAction = UIAlertAction(title: "Zulassen", style: .default) { (alert) in
            
            // get the url to the settings page of the device
            
            let url = URL(string: UIApplication.openSettingsURLString)
            
            if let url = url {
                
                UIApplication.shared.open(url, options: [:], completionHandler: nil)
                
            }
        }
        
        // add the settings action
        alert.addAction(settingsAction)
        
        // create the cancel action
        let cancelAction = UIAlertAction(title: "Abbrechen", style: .cancel, handler: nil)
        
        // add the cancel action
        alert.addAction(cancelAction)
        
        // show the alert
        present(alert, animated: true, completion: nil)
    }
}


