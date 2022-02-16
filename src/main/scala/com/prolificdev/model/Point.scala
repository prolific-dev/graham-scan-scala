package com.prolificdev.model.pointComponent.pointBasicImpl

import com.prolificdev.model.pointComponent.PointInterface
import com.google.inject.Inject

case class Point(x: Int, y: Int) {


    override def toString: String = "(" + x + " | " + y + ")"
}