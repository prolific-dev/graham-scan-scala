package com.prolificdev.grahamscan

import com.google.inject.Guice
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.model.fileIoComponent.FileIOInterface
import com.prolificdev.grahamscan.model.Point

object GrahamScan {
  @main def hello: Unit = {
    println("Welcome to the GrahamScan Application!")
    println(msg)

    val injector = Guice.createInjector(new GrahamScanModule)
    val io = injector.getInstance(classOf[FileIOInterface])
    val calc = injector.getInstance(classOf[CalculateInterface])
    val points = Seq(Point(1, 0), Point(0, 1), Point(1, 1), Point(1, 0))

    io.save(points)
    io.load.foreach(println)
    println("")
    println("")
    calc.getRawDataSet.foreach(println)
  }

  def msg = "I was compiled by Scala 3. :)"

}
