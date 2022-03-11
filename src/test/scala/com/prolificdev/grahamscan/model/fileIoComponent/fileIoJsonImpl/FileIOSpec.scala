package com.prolificdev.grahamscan.model.fileIoComponent.fileIoJsonImpl

import com.prolificdev.grahamscan.util.Point
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.io.File

class FileIOSpec extends AnyWordSpec with Matchers {
  "A FileIO" when {
    "created" should {
      val fileIO = new FileIO

      "be able to save and load a set of points to a JSON file" in {
        val pointsFile = new File(getClass.getResource("/json/points-test.json").toURI)
        val points = Vector(Point(0, 0), Point(0, 1), Point(1, 0), Point(1, 1))
        fileIO.save(points, pointsFile)
        fileIO.load(pointsFile) should be(Vector(Point(0, 0), Point(0, 1), Point(1, 0), Point(1, 1)))
      }
      "be able to convert data from a text file to a vector of points" in {
        val dirtyFile = new File(getClass.getResource("/txt/dirty-test.txt").toURI)
        fileIO.convert(dirtyFile) should be(
          Vector(
            Point(0, 0),
            Point(0, 1),
            Point(1, 0),
            Point(1, 1)
          )
        )
      }
    }
  }
}
