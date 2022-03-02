package com.prolificdev.grahamscan.aview.tui

import com.google.inject.Guice
import com.prolificdev.grahamscan.GrahamScanModule
import com.prolificdev.grahamscan.controller.controllerComponent.controllerBasicImpl.Controller
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TUISpec extends AnyWordSpec with Matchers {
  "A TUI" when {
    val injector = Guice.createInjector(new GrahamScanModule)
    val calc = injector.getInstance(classOf[CalculateInterface])
    val controller = new Controller(calc)
    "created" should {
      val tui = new TUI(controller)
    }
  }
}
