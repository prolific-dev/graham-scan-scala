package com.prolificdev.grahamscan.model.fileIoComponent.fileIoJsonImpl

import com.prolificdev.grahamscan.model.Point
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FileIOSpec extends AnyWordSpec with Matchers {
  "A FileIO" when {
    "created" should {
      val fileIO = new FileIO
      "be able to save and load a set of points to a JSON file" in {
        val points = Seq(Point(0, 0), Point(0, 1), Point(1, 0), Point(1, 1))
        fileIO.save(points)
        fileIO.load should be(Seq(Point(0, 0), Point(0, 1), Point(1, 0), Point(1, 1)))
      }
    }
  }
}
