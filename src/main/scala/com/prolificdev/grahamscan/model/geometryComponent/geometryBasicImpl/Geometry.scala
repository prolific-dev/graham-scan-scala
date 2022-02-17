package com.prolificdev.grahamscan.model.geometryComponent.geometryBasicImpl

import com.google.inject.Inject
import com.prolificdev.grahamscan.model.Point
import com.prolificdev.grahamscan.model.geometryComponent.GeometryInterface

class Geometry @Inject extends GeometryInterface {
  override def angle(p1: Point, p2: Point): Double =
    val theta = math.atan2(p1.y - p2.y, p1.x - p2.x) + math.Pi / 2.0
    val angle = math.toDegrees(theta)
    if (angle < 0) angle + 360 else angle
}
