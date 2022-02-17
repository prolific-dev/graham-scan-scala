package com.prolificdev.grahamscan.model.calculateComponent.calculateBasicImpl

import com.google.inject.{Guice, Inject, Injector}
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.model.fileIoComponent.FileIOInterface
import com.prolificdev.grahamscan.model.geometryComponent.GeometryInterface
import com.prolificdev.grahamscan.model.Point
import com.prolificdev.grahamscan.GrahamScanModule

class Calculate @Inject extends CalculateInterface {
  val injector: Injector = Guice.createInjector(new GrahamScanModule)
  val io: FileIOInterface = injector.getInstance(classOf[FileIOInterface])
  val geo: GeometryInterface = injector.getInstance(classOf[GeometryInterface])

  var raw: Set[Point] = getRawDataSet
  var startPoint: Point = getStartPoint
  var orderedList: List[Point] = getOrderedList
  var inner: Seq[Point] = Seq()
  var hull: Seq[Point] = Seq()

  override def getRawDataSet: Set[Point] = io.load.toSet

  override def getStartPoint: Point = raw.reduce((a, b) => if (a.y < b.y) a else b)

  override def getOrderedList: List[Point] = (raw - startPoint).toList
}
