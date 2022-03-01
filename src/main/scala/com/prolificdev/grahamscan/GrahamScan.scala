package com.prolificdev.grahamscan

import com.prolificdev.grahamscan.model.{Calculate, FileIO, Point}

object GrahamScan {
  @main def hello: Unit = {
    println("Welcome to the GrahamScan Application!")
    println(msg)

    val io = new FileIO

    val points = Vector(Point(1, 0), Point(0, 1), Point(1, 1), Point(1, 0))

    val calc = new Calculate(points)
    io.save(points)
    io.load.foreach(println)
    println("")
    println("")
  }

  def msg = "I was compiled by Scala 3. :)"

}
