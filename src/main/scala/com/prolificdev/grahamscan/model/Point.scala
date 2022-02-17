package com.prolificdev.grahamscan.model

case class Point(x: Double, y: Double) {

  override def toString: String = "(" + x + " | " + y + ")"
}
