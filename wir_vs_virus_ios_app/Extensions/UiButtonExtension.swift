//
//  UiButtonExtension.swift
//  wir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin  on 21.03.20.
//  Copyright © 2020 Fischer, Benjamin  All rights reserved.
//

import UIKit

extension UIButton {
    
    func makeButtonRound(radius: CGFloat, borderWidth: CGFloat, borderColor: UIColor) {
        
        self.layer.cornerRadius = radius
        self.layer.borderWidth = borderWidth
        self.layer.borderColor = borderColor.cgColor
        
    }
    
}
