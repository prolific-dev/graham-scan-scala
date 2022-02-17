package com.prolificdev.model.fileIoComponent.fileIoJsonImpl

import com.google.inject.Inject
import com.prolificdev.{GrahamScan, GrahamScanModule}
import com.prolificdev.model.fileIoComponent.FileIOInterface
import com.prolificdev.model.Point
import play.api.libs.json.{JsObject, Json}

import java.io.{File, PrintWriter}
import scala.io.Source

class FileIO @Inject extends FileIOInterface {
  val file = new File("src/main/resources/json/points.json")

  override def load: Seq[Point] =
    val source = Source.fromFile(file)
    val lines = source.getLines.mkString
    val json = Json.parse(lines)
    val size = (json \ "size").get.toString.toInt
    var seq: Seq[Point] = Seq()
    for (i <- 0 until size) {
      val x = (json \\ "x") (i).as[Int]
      val y = (json \\ "y") (i).as[Int]
      seq = seq :+ Point(x, y)
    }
    seq

  override def save(points: Seq[Point]): Unit =
    val pw = new PrintWriter(file)
    pw.write(Json.prettyPrint(pointsToJson(points)))
    pw.close()

  def pointsToJson(points: Seq[Point]): JsObject =
    Json.obj(
      "size" -> points.size,
      "points" -> Json.toJson(
        for i <- points.indices yield pointToJson(points(i))
      )
    )

  def pointToJson(point: Point): JsObject = Json.obj("x" -> point.x, "y" -> point.y)

}
