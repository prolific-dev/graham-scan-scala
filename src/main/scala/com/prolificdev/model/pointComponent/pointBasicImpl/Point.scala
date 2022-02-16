package com.prolificdev.model.pointComponent.pointBasicImpl

import com.prolificdev.model.pointComponent.PointInterface
import com.google.inject.Inject

class Point @Inject (x: Int, y: Int) extends PointInterface {

    override def toString: String = "(" + x + " | " + y + ")"
}