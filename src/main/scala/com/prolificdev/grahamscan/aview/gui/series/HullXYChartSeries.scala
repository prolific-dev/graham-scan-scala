package com.prolificdev.grahamscan.aview.gui.series

import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface
import scalafx.collections.ObservableBuffer
import scalafx.scene.chart.XYChart

case class HullXYChartSeries(controller: ControllerInterface) extends XYChart.Series[Number, Number] {
  name = "Convex Hull"
  data = ObservableBuffer(controller.calc.hull.map(p => XYChart.Data[Number, Number](p.x, p.y)): _*)
}
