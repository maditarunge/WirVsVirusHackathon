//
//  ApiError.swift
//  FFM.de App
//
//  Created by Fischer, Benjamin  on 04.12.18.
//  Copyright © 2020 Fischer, Benjamin . All rights reserved.
//

import Foundation

enum ApiError: Error {
    
    case badRequest // status code 400
    case notAuthorize // status code 401
    case notFound // status code 404
    case timeOut // status code 408
    case tooManyRequests // status code 429
    case internalServerError // status code 500
    case serviceUnavailable // status code 503
    case noConnectivity // no internet connectivity on this device
    case undefinedError // undefined error
    
}
