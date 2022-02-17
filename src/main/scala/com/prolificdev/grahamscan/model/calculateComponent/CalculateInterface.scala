package com.prolificdev.grahamscan.model.calculateComponent

import com.prolificdev.grahamscan.model.Point

trait CalculateInterface {

  def getRawDataSet: Set[Point]

  def getStartPoint: Point

  def getOrderedList: List[Point]
}
