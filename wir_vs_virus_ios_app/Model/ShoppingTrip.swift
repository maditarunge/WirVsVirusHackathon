//
//  Shopper.swift
//  wir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin  on 21.03.20.
//  Copyright © 2020 Fischer, Benjamin . All rights reserved.
//

import Foundation

struct ShoppingTrip: Codable {
    
    var id:Int?
    var shopper:User?
    var coordinate:Coordinate?
    var title:String?
    var date:String?
    
}
