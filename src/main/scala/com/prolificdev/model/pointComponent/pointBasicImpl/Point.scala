package com.prolificdev.model.pointComponent.pointBasicImpl

import com.prolificdev.model.pointComponent.PointInterface

case class Point(x: Int, y: Int) extends PointInterface {

    override def toString: String = "(" + x + " | " + y + ")"
}