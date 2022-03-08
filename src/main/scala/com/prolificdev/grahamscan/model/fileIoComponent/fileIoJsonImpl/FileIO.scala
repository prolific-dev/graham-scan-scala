package com.prolificdev.grahamscan.model.fileIoComponent.fileIoJsonImpl

import com.google.inject.Inject
import com.prolificdev.grahamscan.model.fileIoComponent.FileIoInterface
import com.prolificdev.grahamscan.util.Point
import play.api.libs.json.{JsObject, Json}

import java.io.{File, PrintWriter}
import java.net.URI
import scala.io.Source

class FileIO @Inject extends FileIoInterface {
  val uri: URI = getClass.getResource("/json/points.json").toURI
  val file = new File(uri)

  override def convert: Vector[Point] =
    val dirtyURI = getClass.getResource("/txt/dirty.txt").toURI
    val dirtyFile = new File(dirtyURI)
    val source = Source.fromFile(dirtyFile)
    val lines = source.getLines
    lines
      .map(line => {
        val x = line.split(",")(0).toDouble
        val y = line.split(",")(1).toDouble
        Point(x, y)
      })
      .toVector

  override def load: Vector[Point] =
    val source = Source.fromFile(file)
    val lines = source.getLines.mkString
    val json = Json.parse(lines)
    val size = (json \ "size").get.toString.toInt
    var vector: Vector[Point] = Vector()
    for (i <- 0 until size) {
      val x = (json \\ "x") (i).as[Double]
      val y = (json \\ "y") (i).as[Double]
      vector = vector :+ Point(x, y)
    }
    vector

  override def save(points: Vector[Point]): Unit =
    val pw = new PrintWriter(file)
    pw.write(Json.prettyPrint(pointsToJson(points)))
    pw.close()

  def pointsToJson(points: Vector[Point]): JsObject =
    Json.obj(
      "size" -> points.size,
      "points" -> Json.toJson(for i <- points.indices yield pointToJson(points(i)))
    )

  def pointToJson(point: Point): JsObject = Json.obj("x" -> point.x, "y" -> point.y)

}
