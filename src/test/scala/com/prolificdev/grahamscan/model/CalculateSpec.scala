package com.prolificdev.grahamscan.model

import com.prolificdev.grahamscan.model.Calculate
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CalculateSpec extends AnyWordSpec with Matchers {
  "A Calculate" when {
    val vector: Vector[Point] =
      Vector(
        Point(1, 1),
        Point(1, 1),
        Point(2, 2),
        Point(2, 2),
        Point(3, 2),
        Point(3, 3),
        Point(6, 6)
      )
    "created" should {
      val calc = Calculate(vector)

      "have a method to get a raw data set" in {
        calc.inputToSet should be(
          Set(
            Point(1, 1),
            Point(2, 2),
            Point(3, 2),
            Point(3, 3),
            Point(6, 6)
          )
        )
      }

      "have a method to get the starting point" in {
        calc.startingPoint should be(Point(1, 1))
      }

      "have a method to get a clean data set with the starting point removed" in {
        calc.cleanedData.size should be(calc.inputToSet.size - 1)
        calc.cleanedData.contains(Point(1, 1)) should be(false)
      }

      "have a method to get all points grouped by each angle to starting point" in {
        val geo = new Geometry

        val sp = calc.startingPoint

        val a0 = geo.angle(sp, Point(2, 2)) // 315.0
        val a1 = geo.angle(sp, Point(3, 2)) // 296.565051177078
        val a2 = geo.angle(sp, Point(3, 3)) // 315.0
        val a3 = geo.angle(sp, Point(6, 6)) // 315.0

        calc.allAnglesData(a0) should be(Vector(Point(3, 3), Point(2, 2), Point(6, 6)))
        calc.allAnglesData(a1) should be(Vector(Point(3, 2)))
      }

      "have a method to get the point with max distance for each angle" in {
        val geo = new Geometry

        val sp = calc.startingPoint

        val a0 = 315.0
        val a1 = 296.565051177078

        val d0 = geo.distance(sp, Point(2, 2)) // distance: 1.4142135623730951  angleGroup: a0
        val d1 = geo.distance(sp, Point(3, 2)) // distance: 2.23606797749979    angleGroup: a1
        val d2 = geo.distance(sp, Point(3, 3)) // distance: 2.8284271247461903  angleGroup: a0
        val d3 = geo.distance(sp, Point(6, 6)) // distance: 7.0710678118654755  angleGroup: a0

        calc.maxDistancePoints(a0) should be(Point(6, 6))
        calc.maxDistancePoints(a1) should be(Point(3, 2))
      }

      "have a method to get all collinear points" in {
        calc.collinearPoints should be(Vector(Point(3, 3), Point(2, 2)))
      }

      "have a method to get all points sorted by the angle to the starting point" in {
        calc.sortedData should be(Vector(Point(3, 2), Point(6, 6)))
      }

      "have a method to get the convex hull points in a vector" in {
        calc.hull should be(Vector(Point(6, 6), Point(3, 2), Point(1, 1)))
      }

      "have a method to get the inner points in a vector" in {
        calc.inner should be(Vector(Point(2, 2), Point(3, 3)))
      }
    }
  }
}
