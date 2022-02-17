package com.prolificdev.grahamscan.controller.controllerComponent.controllerBasicImpl

import com.google.inject.{Guice, Inject, Injector}
import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.model.fileIoComponent.FileIOInterface
import com.prolificdev.grahamscan.model.Point
import com.prolificdev.grahamscan.GrahamScanModule

class Controller @Inject(calc: CalculateInterface) extends ControllerInterface {
  val injector: Injector = Guice.createInjector(new GrahamScanModule)
  val io: FileIOInterface = injector.getInstance(classOf[FileIOInterface])

  def save(points: Seq[Point]): Unit =
    io.save(points)

  def load: Unit = io.load
}
