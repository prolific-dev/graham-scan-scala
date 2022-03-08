package com.prolificdev.grahamscan.aview.gui.series

import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface
import scalafx.collections.ObservableBuffer
import scalafx.scene.chart.XYChart

case class InnerXYChartSeries(controller: ControllerInterface) extends XYChart.Series[Number, Number] {
  name = "Inner Points"
  data = ObservableBuffer(controller.calc.inner.map(p => XYChart.Data[Number, Number](p.x, p.y)): _*)
}
