package com.prolificdev.grahamscan.controller.controllerComponent.controllerBasicImpl

import com.google.inject.{Guice, Inject, Injector}
import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface
import com.prolificdev.grahamscan.controller.Status
import com.prolificdev.grahamscan.model.calculateComponent.calculateBasicImpl.Calculate
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.model.fileIoComponent.FileIoInterface
import com.prolificdev.grahamscan.util.Point
import com.prolificdev.grahamscan.GrahamScanModule

import java.io.File

class Controller(var calc: CalculateInterface) extends ControllerInterface {
  val injector: Injector = Guice.createInjector(new GrahamScanModule)
  val io: FileIoInterface = injector.getInstance(classOf[FileIoInterface])
  var status: Status = Status.IDLE

  override def clear(): Unit =
    changeInput(Vector(Point(0, 0)))
    status = Status.CLEARED
    notifyObserver()

  override def changeInput(points: Vector[Point]): Unit =
    calc = injector.getInstance(classOf[CalculateInterface]).changeInput(points)
    status = Status.CHANGED
    notifyObserver()

  override def save(points: Vector[Point], file: File): Unit =
    io.save(points, file)
    status = Status.SAVED
    notifyObserver()

  override def load(file: File): Unit =
    calc = calc.changeInput(io.load(file))
    status = Status.LOADED
    notifyObserver()

  override def convert(file: File): Unit =
    calc = calc.changeInput(io.convert(file))
    status = Status.CONVERTED
    notifyObserver()
}
