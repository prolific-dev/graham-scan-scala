package com.prolificdev.grahamscan.model.geometryComponent.geometryBasicImpl

import com.prolificdev.grahamscan.model.Point
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
    }
  }

}
