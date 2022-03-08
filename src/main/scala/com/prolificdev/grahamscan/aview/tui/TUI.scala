package com.prolificdev.grahamscan.aview.tui

import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface
import com.prolificdev.grahamscan.model.fileIoComponent.fileIoJsonImpl.FileIO
import com.prolificdev.grahamscan.util.{Observer, Point}

import scala.io.StdIn.readLine

class TUI(controller: ControllerInterface) extends Observer {
  controller.add(this)

  def run(): Unit =
    println("Welcome to the Graham Scan Calculation Software")
    inputLoop()

  def inputLoop(): Unit =
    readLine match {
      case "q" =>
      case input: String => processInputLine(input); inputLoop()
    }

  def processInputLine(input: String): Unit =
    input match {
      case "n" => controller.clear()
      case "c" => controller.convert()
      case "s" => controller.save(controller.calc.input)
      case "l" => controller.load()
    }

  override def update(): Unit =
    println(controller.status.message)
    println("\nInput Data: " + controller.calc.input.toString)
    println("\nInner Data: " + controller.calc.inner.toString)
    println("Hull Data" + controller.calc.hull.toString)

}
