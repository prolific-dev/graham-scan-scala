package com.prolificdev.grahamscan.controller.controllerComponent.controllerBasicImpl

import com.google.inject.{Guice, Inject, Injector}
import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface
import com.prolificdev.grahamscan.controller.Status
import com.prolificdev.grahamscan.model.calculateComponent.calculateBasicImpl.Calculate
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.model.fileIoComponent.FileIoInterface
import com.prolificdev.grahamscan.util.Point
import com.prolificdev.grahamscan.GrahamScanModule

class Controller(var calc: CalculateInterface) extends ControllerInterface {
  val injector: Injector = Guice.createInjector(new GrahamScanModule)
  val io: FileIoInterface = injector.getInstance(classOf[FileIoInterface])
  var status: Status = Status.IDLE

  override def save(points: Vector[Point]): Unit =
    io.save(points)
    status = Status.SAVED
    notifyObserver

  override def load: Unit =
    calc = injector.getInstance(classOf[CalculateInterface]).changeInput(io.load)
    status = Status.LOADED
    notifyObserver
}
