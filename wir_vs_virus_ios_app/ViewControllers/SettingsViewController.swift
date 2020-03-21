//
//  SettingsViewController.swift
//  wir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin (polidia) on 21.03.20.
//  Copyright © 2020 Fischer, Benjamin (polidia). All rights reserved.
//

import UIKit

class SettingsViewController: UIViewController {
    
    // MARK: IBoutlet propertes
    
    @IBOutlet weak var scrollView: UIScrollView!
    @IBOutlet weak var contentView: UIView!
    @IBOutlet weak var userProfileImageView: UIImageView!
    @IBOutlet weak var personalDataSection: UIView!
    @IBOutlet weak var firstnameField: UITextField!
    @IBOutlet weak var lastnameField: UITextField!
    @IBOutlet weak var addressDataSection: UIView!
    @IBOutlet weak var addressDataInfoLabel: UILabel!
    @IBOutlet weak var streetField: UITextField!
    @IBOutlet weak var postcodeField: UITextField!
    @IBOutlet weak var cityField: UITextField!
    @IBOutlet weak var contactDataSection: UIView!
    @IBOutlet weak var contactDaaInfoLabel: UILabel!
    @IBOutlet weak var phoneField: UITextField!
    @IBOutlet weak var emailField: UITextField!
    @IBOutlet weak var privacySection: UIView!
    @IBOutlet weak var privacyInfoLabel: UILabel!
    
    // MARK: properties
    let user = User.createDummyUser()
    let placeHolderAttribute = [ NSAttributedString.Key.foregroundColor: UIColor.black]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // setting up the different sections
        setupUserProfileImageSection()
        setupUserProfileSection()
        setupAddressDataSection()
        setupContactDataSection()
        setupPrivacySection()
        
        // register the keyboard notifications
        registerNotifications()
        
        // adding a tap gesture to hide the keyboard when tapping inside the view
        self.view.addGestureRecognizer(UITapGestureRecognizer(target: self.view, action: #selector(UIView.endEditing(_:))))
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
        // dispose any resources that can be restored
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        // unregister the noficiations when the view will disappear
        unregisterNotifications()
    }
    
    // MARK: private functions
    /**
     This function will handle the profile image setup
     */
    private func setupUserProfileImageSection() {
        // TODO hier irgendwann umbauen in upload button
        let userImage = UIImage(named: "profile")
        userProfileImageView.image = userImage
        userProfileImageView.backgroundColor = Constants.shoppingColor
        userProfileImageView.layer.cornerRadius = userProfileImageView.frame.size.width / 2
        userProfileImageView.clipsToBounds = true
    }
    
    /**
    This function will handle the user profile setup
    */
    private func setupUserProfileSection() {
        let firstnamePlaceHolder = NSMutableAttributedString(string: "Vorname", attributes: placeHolderAttribute )
        firstnameField.attributedText = firstnamePlaceHolder
        firstnameField.delegate = self
        let lastNamePlaceHolder = NSMutableAttributedString(string: "Nachname", attributes: placeHolderAttribute )
        lastnameField.attributedText = lastNamePlaceHolder
        lastnameField.delegate = self
    }
    
    /**
    This function will handle the address data setup
    */
    private func setupAddressDataSection() {
        addressDataSection.makeRound(radius: 10, borderWidth: 0.25, borderColor: .black)
        addressDataInfoLabel.text = "Meine Adresse"
        let streetPlaceHolder = NSMutableAttributedString(string: "Straße", attributes: placeHolderAttribute )
        streetField.attributedText = streetPlaceHolder
        streetField.delegate = self
        let postcodePlaceHolder = NSMutableAttributedString(string: "Postleitzahl", attributes: placeHolderAttribute )
        postcodeField.attributedText = postcodePlaceHolder
        postcodeField.delegate = self
        let cityPlaceHolder = NSMutableAttributedString(string: "Stadt", attributes: placeHolderAttribute )
        cityField.attributedText = cityPlaceHolder
        cityField.delegate = self
    }
    
    /**
    This function will handle the contact data setup
    */
    private func setupContactDataSection() {
        contactDataSection.makeRound(radius: 10, borderWidth: 0.25, borderColor: .black)
        contactDaaInfoLabel.text = "Meine Kontaktdaten"
        let phonePlaceHolder = NSMutableAttributedString(string: "Telefonnummer", attributes: placeHolderAttribute )
        phoneField.attributedText = phonePlaceHolder
        phoneField.delegate = self
        let emailPlaceHolder = NSMutableAttributedString(string: "E-Mail", attributes: placeHolderAttribute )
        emailField.attributedText = emailPlaceHolder
        emailField.delegate = self
    }
    
    /**
    This function will handle the privacy data setup
    */
    private func setupPrivacySection() {
        privacySection.makeRound(radius: 10, borderWidth: 0.25, borderColor: .black)
        privacyInfoLabel.text = "Datenschutz"
    }
    
    /**
     Method will register the keyboard will show and will hide notifications
     */
    private func registerNotifications() {
        // add the keyboard will show notification
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillShow), name: UIResponder.keyboardWillShowNotification, object: nil)
        // add the keyboard will hide notification
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillHide), name: UIResponder.keyboardWillHideNotification, object: nil)
    }
    
    /**
     Method will unregister the keyboard will show and will hide notifications
     */
    private func unregisterNotifications() {
        // remove the keyboard will show notification
        NotificationCenter.default.removeObserver(self, name: UIResponder.keyboardWillShowNotification, object: nil)
        // remove the keyboard will hide notification
        NotificationCenter.default.removeObserver(self, name: UIResponder.keyboardWillHideNotification, object: nil)
    }
    
    /**
     Method is called when the keyboad will show. It scrolls the content view to display the clicked field above the keyboard
     
     - Parameter notification: The notification
     */
    @objc private func keyboardWillShow(notification:NSNotification){
        let userInfo = notification.userInfo!
        var keyboardFrame:CGRect = (userInfo[UIResponder.keyboardFrameBeginUserInfoKey] as! NSValue).cgRectValue
        keyboardFrame = self.view.convert(keyboardFrame, from: nil)
        
        var contentInset:UIEdgeInsets = scrollView.contentInset
        contentInset.bottom = keyboardFrame.size.height
        scrollView.contentInset = contentInset
    }
    
    /**
     Method is called when the keyboad will hide. It scrolls the content view to its original position
     
     - Parameter notification: The notification
     */
    @objc private func keyboardWillHide(notification:NSNotification){
        let contentInset:UIEdgeInsets = UIEdgeInsets.zero
        scrollView.contentInset = contentInset
    }
}

extension SettingsViewController: UITextFieldDelegate {
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        // TODO hier dann das speichern rein, sobald das feld fertig ist
    }
    
}
