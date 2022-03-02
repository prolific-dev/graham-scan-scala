package com.prolificdev.grahamscan.controller.controllerComponent

import com.prolificdev.grahamscan.controller.Status
import com.prolificdev.grahamscan.model.calculateComponent.calculateBasicImpl.Calculate
import com.prolificdev.grahamscan.util.{Observable, Point}

trait ControllerInterface extends Observable {
  def status: Status

  def save(points: Vector[Point]): Unit

  def load: Unit
}
