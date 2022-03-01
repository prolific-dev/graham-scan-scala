package com.prolificdev.grahamscan.model

import com.prolificdev.grahamscan.model.Point
import com.prolificdev.grahamscan.GrahamScanModule

import scala.collection.{immutable, mutable}

class Calculate(input: Vector[Point]) {
  private val geo: Geometry = new Geometry
  private val scan: Scan = Scan(startingPoint, collinearPoints, sortedData)

  def inputToSet: Set[Point] = input.toSet

  def startingPoint: Point = inputToSet.reduce((a, b) => if (a.y < b.y) a else b)

  def cleanedData: Vector[Point] = inputToSet.filterNot(p => p == startingPoint).toVector

  def allAnglesData: Map[Double, Vector[Point]] = cleanedData.groupBy(p => geo.angle(startingPoint, p))

  def maxDistancePoints: Map[Double, Point] = allAnglesData.map(e => e._1 -> e._2.maxBy(p => geo.distance(startingPoint, p)))

  def collinearPoints: Vector[Point] = allAnglesData.flatMap(e => e._2.filterNot(p => p == maxDistancePoints(e._1))).toVector

  def sortedData: Vector[Point] = maxDistancePoints.toVector.sortBy(_._1).map(_._2)

  def hull: Vector[Point] = scan.hull.toVector

  def inner: Vector[Point] = scan.inner.toVector
}
