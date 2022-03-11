package com.prolificdev.grahamscan.controller.controllerComponent.controllerBasicImpl

import com.google.inject.{Guice, Injector}
import com.prolificdev.grahamscan.controller.Status
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.util.{Observer, Point}
import com.prolificdev.grahamscan.GrahamScanModule
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.io.File

class ControllerSpec extends AnyWordSpec with Matchers {
  "A controller" when {
    val injector = Guice.createInjector(new GrahamScanModule)
    val calc = injector.getInstance(classOf[CalculateInterface])
    val points = Vector(Point(0, 0), Point(0, 1), Point(1, 0), Point(1, 1))
    val pointsFile = new File(getClass.getResource("/json/points-test.json").toURI)
    val dirtyFile = new File(getClass.getResource("/txt/dirty-test.txt").toURI)

    "created" should {
      val controller = new Controller(calc)

      "have a always a status" in {
        controller.status should be(Status.IDLE)
        controller.changeInput(Vector(Point(0, 0)))
        controller.status should be(Status.CHANGED)
        controller.clear()
        controller.status should be(Status.CLEARED)
        controller.save(points, pointsFile)
        controller.status should be(Status.SAVED)
        controller.load(pointsFile)
        controller.status should be(Status.LOADED)
        controller.convert(dirtyFile)
        controller.status should be(Status.CONVERTED)
      }
    }

    "observed by an Observer" should {
      val controller = new Controller(calc)
      var updated = false
      val observer = new Observer {
        override def update(): Unit = updated = true
      }
      controller.add(observer)

      "notify its Observer after clear" in {
        updated should be(false)
        controller.clear()
        updated should be(true)
        updated = false // reset for further tests
      }

      "notify its Observer after save" in {
        updated should be(false)
        controller.save(points, pointsFile)
        updated should be(true)
        updated = false // reset for further tests
      }

      "notify its Observer after load" in {
        updated should be(false)
        controller.load(pointsFile)
        updated should be(true)
        updated = false // reset for further tests
      }

      "notify its Observer after convert" in {
        updated should be(false)
        controller.convert(dirtyFile)
        updated should be(true)
        updated = false // reset for further tests
      }
    }
  }
}
