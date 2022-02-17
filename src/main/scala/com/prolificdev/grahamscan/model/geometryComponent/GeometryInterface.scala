package com.prolificdev.grahamscan.model.geometryComponent

import com.prolificdev.grahamscan.model.Point

trait GeometryInterface {
  def angle(p1: Point, p2: Point): Double
}
