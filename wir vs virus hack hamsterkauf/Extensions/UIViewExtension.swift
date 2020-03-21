//
//  UIViewExtension.swift
//  wir vs virus hack hamsterkauf
//
//  Created by Fischer, Benjamin (polidia) on 21.03.20.
//  Copyright © 2020 Fischer, Benjamin (polidia). All rights reserved.
//

import UIKit

extension UIView {
    
    func makeRound(radius: CGFloat, borderWidth: CGFloat, borderColor: UIColor) {
        
        self.layer.cornerRadius = radius
        self.layer.borderWidth = borderWidth
        self.layer.borderColor = borderColor.cgColor
        
    }
    
    func roundCorners(corners: UIRectCorner, radius: CGFloat) {
        let path = UIBezierPath(roundedRect: bounds, byRoundingCorners: corners, cornerRadii: CGSize(width: radius, height: radius))
        let mask = CAShapeLayer()
        mask.path = path.cgPath
        layer.mask = mask
    }
}
