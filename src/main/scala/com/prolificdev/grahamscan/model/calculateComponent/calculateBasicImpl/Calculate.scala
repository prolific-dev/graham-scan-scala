package com.prolificdev.grahamscan.model.calculateComponent.calculateBasicImpl

import com.google.inject.Inject
import com.prolificdev.grahamscan.model.calculateComponent.calculateBasicImpl.Scan
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.util.{Geometry, Point}
import com.prolificdev.grahamscan.GrahamScanModule

import scala.collection.{immutable, mutable}

case class Calculate @Inject(input: Vector[Point]) extends CalculateInterface {
  private val geo: Geometry = new Geometry
  private val scan: Scan = Scan(startingPoint, collinearPoints, sortedData)

  def inputToSet: Set[Point] = input.toSet

  def startingPoint: Point = inputToSet.reduce((a, b) => if (a.y < b.y) a else b)

  def cleanedData: Vector[Point] = inputToSet.filterNot(p => p == startingPoint).toVector

  def allAnglesData: Map[Double, Vector[Point]] = cleanedData.groupBy(p => geo.angle(startingPoint, p))

  def maxDistancePoints: Map[Double, Point] = allAnglesData.map(e => e._1 -> e._2.maxBy(p => geo.distance(startingPoint, p)))

  def collinearPoints: Vector[Point] = allAnglesData.flatMap(e => e._2.filterNot(p => p == maxDistancePoints(e._1))).toVector

  def sortedData: Vector[Point] = maxDistancePoints.toVector.sortBy(_._1).map(_._2)

  override def hull: Vector[Point] = scan.hull.toVector

  override def inner: Vector[Point] = scan.inner.toVector

  override def changeInput(newInput: Vector[Point]): Calculate = copy(input = newInput)
}
