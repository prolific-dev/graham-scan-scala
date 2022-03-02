package com.prolificdev.grahamscan.util

import com.prolificdev.grahamscan.util.{Geometry, Point}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GeometrySpec extends AnyWordSpec with Matchers {
  "A Geometry" when {
    "created" should {
      val geo = new Geometry
      "have a method to calculate the angle between two points" in {
        val center = Point(1, 1)
        val top = Point(1, 2)
        val bottom = Point(1, 0)
        val left = Point(0, 1)
        val right = Point(2, 1)

        geo.angle(center, top) should be(0.0)
        geo.angle(center, bottom) should be(180.0)
        geo.angle(center, left) should be(90.0)
        geo.angle(center, right) should be(270.0)
      }
      "have a method to calculate the distance between two points" in {
        val p1 = Point(0, 0)
        val p2 = Point(1, 1)

        geo.distance(p1, p2) should be(math.sqrt(2))
        geo.distance(p2, p1) should be(math.sqrt(2))

      }
    }
  }

}
