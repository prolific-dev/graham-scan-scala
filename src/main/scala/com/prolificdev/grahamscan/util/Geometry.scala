package com.prolificdev.grahamscan.util

import com.prolificdev.grahamscan.util.Point

import scala.math.*

class Geometry {
  def angle(p1: Point, p2: Point): Double =
    val theta = atan2(p1.y - p2.y, p1.x - p2.x) + math.Pi / 2.0
    val angle = toDegrees(theta)
    if (angle < 0) angle + 360 else angle

  def distance(p1: Point, p2: Point): Double = sqrt(pow(p2.x - p1.x, 2) + pow(p2.y - p1.y, 2))
}
