package com.prolificdev.grahamscan.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.collection.mutable

class ScanSpec extends AnyWordSpec with Matchers {
  "A Scan" when {
    "created" should {
      val startingPoint = Point(1, 0)
      val collinearPoints = Vector(Point(3, 3))
      val sortedData = Vector(Point(6, 0), Point(5, 1), Point(6, 6), Point(0, 6), Point(1, 1))
      val scan = new Scan(startingPoint, collinearPoints, sortedData)

      "have proceeded all undefined points" in {
        scan.undefined.isEmpty should be(true)
      }

      "have a convex hull of points" in {
        scan.hull should be(
          mutable.Stack[Point](
            Point(0, 6),
            Point(6, 6),
            Point(6, 0),
            Point(1, 0)
          )
        )
      }

      "have all points within the convex hull" in {
        scan.inner should be(
          mutable.Stack[Point](
            Point(1, 1),
            Point(5, 1),
            Point(3, 3)
          )
        )
      }
    }
  }

}
