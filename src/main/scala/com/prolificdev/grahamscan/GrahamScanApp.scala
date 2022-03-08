package com.prolificdev.grahamscan

import com.google.inject.{Guice, Injector}
import com.prolificdev.grahamscan.aview.gui.GUI
import com.prolificdev.grahamscan.aview.tui.TUI
import com.prolificdev.grahamscan.controller.controllerComponent.controllerBasicImpl.Controller
import com.prolificdev.grahamscan.model.calculateComponent.calculateBasicImpl.Calculate
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.util.Point
import scalafx.application.JFXApp3

object GrahamScanApp {
  println(msg)
  val injector: Injector = Guice.createInjector(new GrahamScanModule)
  val calc: CalculateInterface = injector.getInstance(classOf[CalculateInterface])
  val controller = new Controller(calc)
  val tui = new TUI(controller)

  def runTUI(): Unit = tui.run()

  def runGUI(): Unit =
    val gui = new GUI(controller)
    gui.start()

  def msg = "I was compiled by Scala 3. :)"
}

object GrahamScanTUI extends App {
  GrahamScanApp.runTUI()
}

object GrahamScanGUI extends JFXApp3 {
  override def start(): Unit = GrahamScanApp.runGUI()
}
