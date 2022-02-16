package com.prolificdev.model.fileIoComponent

import com.google.inject.Inject
import com.prolificdev.model.pointComponent.pointBasicImpl.Point
import com.prolificdev.GrahamScanModule
import java.io.File
import java.io.PrintWriter
import play.api.libs.json.Json
import scala.io.Source

class FileIO @Inject extends FileIOInterface {
  val file = new File("src/main/resources/json/points.json")

  override def load: Seq[Point] =
    val source = Source.fromFile(file).getLines.mkString
    val json = Json.parse(source)
    val size = (json \ "size").get.toString.toInt

    var seq: Seq[Point] = Seq()

    for (i <- 0 until size) {
      val x = (json \\ "x")(i).as[Int]
      val y = (json \\ "y")(i).as[Int]
      seq = seq :+ Point(x, y)
    }
    seq

  override def save(points: Seq[Point]): Unit =
    val pw = new PrintWriter(file)
    pw.write(Json.prettyPrint(pointsToJson(points)))

  def pointsToJson(points: Seq[Point]) =
    Json.obj(
      "size" -> points.size,
      "points" -> Json.toJson(
        for (i <- 0 until points.size)
          yield Json.obj("x" -> points(i).x, "y" -> points(i).y)
      )
    )
}
