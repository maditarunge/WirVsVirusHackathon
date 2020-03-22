//
//  ApiErrorHandler.swift
//  FFM.de App
//
//  Created by Fischer, Benjamin on 19.02.20.
//  Copyright © 2020 Fischer, Benjamin . All rights reserved.
//

import Foundation

class ApiErrorHandler {
    
    /**
     Method handles the given status code and converts it into an api error which can be handled by the view controller
     
     - Parameter statusCode: The status code that should be converted
     
     - Returns: The converted api error
     */
    public static func handleError(_ statusCode: Int?) -> ApiError{
        
        if statusCode == nil {
            return ApiError.serviceUnavailable
        }
        
        let apiError: ApiError
        switch statusCode {
        case 400:
            apiError = ApiError.badRequest
        case 401:
            apiError = ApiError.notAuthorize
        case 404:
            apiError = ApiError.notFound
        case 429:
            apiError = ApiError.tooManyRequests
        case 500:
            apiError = ApiError.internalServerError
        case 503:
            apiError = ApiError.serviceUnavailable
        default:
            apiError = ApiError.undefinedError
        }
        return apiError
        
    }
    
}
