package com.prolificdev.model

case class Point(x: Int, y: Int) {

  override def toString: String = "(" + x + " | " + y + ")"
}
