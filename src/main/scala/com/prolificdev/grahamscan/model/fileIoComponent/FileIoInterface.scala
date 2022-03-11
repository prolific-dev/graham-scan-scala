package com.prolificdev.grahamscan.model.fileIoComponent

import com.prolificdev.grahamscan.util.Point

import java.io.File

trait FileIoInterface {

  def convert(file: File): Vector[Point]

  def save(points: Vector[Point], file: File): Unit

  def load(file: File): Vector[Point]
}
