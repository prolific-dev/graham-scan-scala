package com.prolificdev.grahamscan.model.fileIoComponent

import com.prolificdev.grahamscan.util.Point

trait FileIoInterface {

  def save(points: Vector[Point]): Unit

  def load: Vector[Point]
}
