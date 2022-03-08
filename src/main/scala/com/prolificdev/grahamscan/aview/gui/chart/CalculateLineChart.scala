package com.prolificdev.grahamscan.aview.gui.chart

import com.prolificdev.grahamscan.aview.gui.series.{HullXYChartSeries, InnerXYChartSeries}
import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface
import scalafx.collections.ObservableBuffer
import scalafx.scene.chart.{LineChart, NumberAxis}

class CalculateLineChart(controller: ControllerInterface)
  extends LineChart[Number, Number](
    NumberAxis("x-Axis", 0, 11, 1),
    NumberAxis("x-Axis", 0, 11, 1),
    ObservableBuffer(HullXYChartSeries(controller), InnerXYChartSeries(controller))
  ) {
  title = "Convex Hull Calculator"
  stylesheets = ObservableBuffer(getClass.getResource("/css/chart.css").toExternalForm)
}
