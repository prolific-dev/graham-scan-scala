package com.prolificdev.grahamscan.controller.controllerComponent

import com.prolificdev.grahamscan.controller.Status
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.util.{Observable, Point}

trait ControllerInterface extends Observable {
  def calc: CalculateInterface

  def status: Status

  def changeInput(points: Vector[Point]): Unit

  def clear(): Unit

  def save(points: Vector[Point]): Unit

  def load(): Unit

  def convert(): Unit
}
