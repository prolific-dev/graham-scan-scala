package com.prolificdev.grahamscan

import com.google.inject.Guice
import com.prolificdev.grahamscan.aview.tui.TUI
import com.prolificdev.grahamscan.controller.controllerComponent.controllerBasicImpl.Controller
import com.prolificdev.grahamscan.model.calculateComponent.calculateBasicImpl.Calculate
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.util.Point

object GrahamScan {
  @main def hello: Unit = {
    println(msg)
    val injector = Guice.createInjector(new GrahamScanModule)
    val calc = injector.getInstance(classOf[CalculateInterface])
    val controller = new Controller(calc)
    val tui = new TUI(controller)

    tui.run
  }

  def msg = "I was compiled by Scala 3. :)"

}
