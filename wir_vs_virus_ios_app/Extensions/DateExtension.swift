//
//  DateExtension.swift
//  wir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin  on 21.03.20.
//  Copyright © 2020 Fischer, Benjamin . All rights reserved.
//

import Foundation

extension Date {
    
    /**
     Converts a string to an date object
     
     - Parameter fromString: The input String that should be converted
     
     - Returns: The converted date object
    */
    static func convertStringToDate(fromString: String) -> Date {
        let dateFormatterGet = DateFormatter()
        dateFormatterGet.dateFormat = "yyyy-MM-dd HH:mm:ss.SSS"
        
        let date: Date? = dateFormatterGet.date(from: fromString)
        return date!
    }
    
    func getFormattedDateString(dateFormat: String)-> String{
          let dateFormatter = DateFormatter()
        
          dateFormatter.dateFormat = dateFormat
          return dateFormatter.string(from: self)
    }
    
    
    
}
