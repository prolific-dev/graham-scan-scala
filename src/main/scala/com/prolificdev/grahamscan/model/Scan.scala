package com.prolificdev.grahamscan.model

import scala.collection.mutable

class Scan(startingPoint: Point, collinearPoints: Vector[Point], sortedData: Vector[Point]) {
  val undefined: mutable.Stack[Point] = new mutable.Stack[Point]().pushAll(sortedData.reverse)
  val inner: mutable.Stack[Point] = new mutable.Stack[Point]().pushAll(collinearPoints)
  val hull: mutable.Stack[Point] = new mutable.Stack[Point]().push(startingPoint)

  while (undefined.nonEmpty)
    val pointToCheck = undefined.pop
    val lastPointFromHull = hull.head

    if (undefined.nonEmpty)
      val nextPoint = undefined.head
      if (locatedOnHull(pointToCheck, nextPoint, lastPointFromHull)) hull.push(pointToCheck)
      else
        inner.push(pointToCheck)
        undefined.push(hull.pop)
    else
      val nextPoint = startingPoint
      if (locatedOnHull(pointToCheck, nextPoint, lastPointFromHull)) hull.push(pointToCheck)
      else inner.push(pointToCheck)

  def locatedOnHull(pointToCheck: Point, nextPoint: Point, lastPointFromHull: Point): Boolean =
    val x1 = nextPoint.x - lastPointFromHull.x
    val y1 = nextPoint.y - lastPointFromHull.y
    val x2 = pointToCheck.x - lastPointFromHull.x
    val y2 = pointToCheck.y - lastPointFromHull.y
    val crossProduct = x1 * y2 - y1 * x2
    crossProduct <= 0
}
