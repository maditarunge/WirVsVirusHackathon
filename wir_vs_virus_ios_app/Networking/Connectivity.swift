//
//  Connectivity.swift
//  FFM.de App
//
//  Created by Fischer, Benjamin on 07.12.18.
//  Copyright © 2020 Fischer, Benjamin . All rights reserved.
//

import Foundation
import Alamofire

class Connectivity {
    
    class var isConnectedToInternet: Bool {
        return NetworkReachabilityManager()!.isReachable
    }
}
