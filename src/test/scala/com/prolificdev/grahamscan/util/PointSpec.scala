package com.prolificdev.grahamscan.util

import com.prolificdev.grahamscan.util.Point
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PointSpec extends AnyWordSpec with Matchers {
  "A point" when {
    "created" should {
      val p = Point(0, 0)
      "have a simple string representation" in {
        p.toString should be("(0.0 | 0.0)")
      }
    }
  }
}
