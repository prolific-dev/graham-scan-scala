package com.prolificdev.model.pointComponent.pointBasicImpl

case class Point(x: Int, y: Int) {

  override def toString: String = "(" + x + " | " + y + ")"
}
