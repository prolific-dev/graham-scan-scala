package com.prolificdev.grahamscan.controller.controllerComponent.controllerBasicImpl

import com.google.inject.{Guice, Injector}
import com.prolificdev.grahamscan.GrahamScanModule
import com.prolificdev.grahamscan.controller.Status
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.util.{Observer, Point}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ControllerSpec extends AnyWordSpec with Matchers {
  "A controller" when {
    val injector = Guice.createInjector(new GrahamScanModule)
    val calc = injector.getInstance(classOf[CalculateInterface])
    val points = Vector(Point(0, 0), Point(0, 1), Point(1, 0), Point(1, 1))


    "created" should {
      val controller = new Controller(calc)

      "have a always a status" in {
        controller.status should be(Status.IDLE)
        controller.save(points)
        controller.status should be(Status.SAVED)
        controller.load
        controller.status should be(Status.LOADED)
      }
    }

    "observed by an Observer" should {
      val controller = new Controller(calc)
      var updated = false
      val observer = new Observer {
        override def update: Unit = updated = true
      }
      controller.add(observer)

      "notify its Observer after save" in {
        updated should be(false)
        controller.save(points)
        updated should be(true)
        updated = false // reset for further tests
      }

      "notify its Observer after load" in {
        updated should be(false)
        controller.load
        updated should be(true)
        updated = false // reset for further tests
      }
    }
  }
}
