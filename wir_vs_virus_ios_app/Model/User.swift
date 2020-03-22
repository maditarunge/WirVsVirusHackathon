//
//  User.swift
//  wir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin  on 21.03.20.
//  Copyright © 2020 Fischer, Benjamin . All rights reserved.
//

import Foundation

struct User: Codable {
    
    var token: String?
    var id: Int?
    var firstname: String?
    var name: String?
    var email: String?
    var street: String?
    var housenumber: String?
    var postcode: String?
    var city: String?
    var password:String?
    
    static func createDummyUser() -> User {
        var user = User()
        user.firstname = "Max"
        user.name = "Musterman"
        user.city = "Berlin"
        return user
    }
}
