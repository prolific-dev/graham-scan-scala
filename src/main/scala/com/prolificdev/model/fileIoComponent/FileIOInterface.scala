package com.prolificdev.model.fileIoComponent

import com.prolificdev.model.Point

trait FileIOInterface {
  def load: Seq[Point]

  def save(points: Seq[Point]): Unit
}
