package com.prolificdev

import com.google.inject.Guice
import com.prolificdev.model.fileIoComponent.FileIOInterface
import com.prolificdev.model.Point

object GrahamScan {
  @main def hello: Unit =
    println("Welcome to the GrahamScan Application!")
    println(msg)

    val injector = Guice.createInjector(new GrahamScanModule)
    val io = injector.getInstance(classOf[FileIOInterface])
    val points = Seq(Point(18, 10), Point(19, 12))

    io.save(points)
    io.load.foreach(println)

  def msg = "I was compiled by Scala 3. :)"

}
