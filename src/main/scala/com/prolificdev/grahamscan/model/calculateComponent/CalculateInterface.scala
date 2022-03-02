package com.prolificdev.grahamscan.model.calculateComponent

import com.prolificdev.grahamscan.util.Point

trait CalculateInterface {
  def input: Vector[Point]

  def hull: Vector[Point]

  def inner: Vector[Point]

  def changeInput(newInput: Vector[Point]): CalculateInterface
}
