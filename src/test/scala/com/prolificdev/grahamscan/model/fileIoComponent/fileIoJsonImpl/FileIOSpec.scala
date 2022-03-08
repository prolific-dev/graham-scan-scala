package com.prolificdev.grahamscan.model.fileIoComponent.fileIoJsonImpl

import com.prolificdev.grahamscan.util.Point
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FileIOSpec extends AnyWordSpec with Matchers {
  "A FileIO" when {
    "created" should {
      val fileIO = new FileIO
      "be able to save and load a set of points to a JSON file" in {
        val points = Vector(Point(0, 0), Point(0, 1), Point(1, 0), Point(1, 1))
        fileIO.save(points)
        fileIO.load should be(Vector(Point(0, 0), Point(0, 1), Point(1, 0), Point(1, 1)))
      }
      "be able to convert data from a text file to a vector of points" in {
        fileIO.convert should be(
          Vector(
            Point(1, 1),
            Point(1, 5),
            Point(5, 5),
            Point(5, 1),
            Point(2, 3),
            Point(3, 3),
            Point(4, 3),
            Point(2, 2),
            Point(3, 2),
            Point(4, 2),
            Point(2, 4),
            Point(3, 4),
            Point(4, 4)
          )
        )
      }
    }
  }
}
