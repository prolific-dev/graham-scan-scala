package com.prolificdev.grahamscan.controller.controllerComponent.controllerBasicImpl

import com.google.inject.{Guice, Inject, Injector}
import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface
import com.prolificdev.grahamscan.model.{Calculate, FileIO, Point}
import com.prolificdev.grahamscan.GrahamScanModule

class Controller @Inject(calc: Calculate) extends ControllerInterface {
  val injector: Injector = Guice.createInjector(new GrahamScanModule)
  val io = new FileIO

  def save(points: Vector[Point]): Unit =
    io.save(points)

  def load: Unit = io.load
}
