package com.prolificdev.grahamscan.model.fileIoComponent

import com.prolificdev.grahamscan.model.Point

trait FileIOInterface {
  def load: Seq[Point]

  def save(points: Seq[Point]): Unit
}
