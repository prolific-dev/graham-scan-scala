package com.prolificdev.grahamscan.aview.gui

import com.prolificdev.grahamscan.aview.gui.chart.CalculateLineChart
import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface
import com.prolificdev.grahamscan.util.Observer
import scalafx.application.{HostServices, JFXApp3}
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Insets
import scalafx.geometry.Pos.Center
import scalafx.scene.chart.{LineChart, NumberAxis, XYChart}
import scalafx.scene.chart.XYChart.Series
import scalafx.scene.control.*
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.{AnchorPane, HBox, VBox}
import scalafx.scene.layout.Priority.Always
import scalafx.scene.text.{Font, Text, TextAlignment}
import scalafx.scene.text.FontWeight.Bold
import scalafx.scene.Scene
import scalafx.Includes.*

class GUI(controller: ControllerInterface) extends JFXApp3 with Observer {
  var chartSceneIsSet = false
  controller.add(this)

  def switchScene(): Unit =
    if (chartSceneIsSet)
      chartSceneIsSet = false
      update()
    else
      chartSceneIsSet = true
      update()

  def menuScene: Scene = new Scene {
    root = new VBox {
      // padding = Insets(0, 0, 0, 0)
      children = Seq(
        new Text("Welcome to the Convex Hull Calculator") {
          margin = Insets(100, 0, 0, 0)
          textAlignment = TextAlignment.Center
          wrappingWidth = 800
          font = Font("System", Bold, 38)
        },
        new ImageView(getClass.getResource("/icons/icons8-g-64.png").toExternalForm) {
          margin = Insets(50, 300, 0, 300)
          alignment = Center

        },
        new HBox {
          margin = Insets(80, 0, 0, 0)
          spacing = 30
          alignment = Center
          children = Seq(
            new Button("New") {
              prefWidth = 150
              prefHeight = 60
              font = Font("System", 24)
              onAction = e =>
                controller.clear()
                switchScene()
            },
            new Button("Open") {
              prefWidth = 150
              prefHeight = 60
              font = Font("System", 24)
              onAction = e =>
                controller.load()
                switchScene()
            },
            new Button("Exit") {
              prefWidth = 150
              prefHeight = 60
              font = Font("System", 24)
              onAction = e => sys.exit(0)
            }
          )
        }
      )
    }
  }

  def chartScene: Scene = new Scene {
    root = new VBox {
      children = Seq(
        new MenuBar {
          menus = Seq(
            new Menu("File") {
              items = Seq(
                new MenuItem("New") {
                  onAction = e => controller.clear()
                },
                new MenuItem("Load") {
                  onAction = e => controller.load()
                },
                new MenuItem("Save") {
                  onAction = e => controller.save(controller.calc.input)
                },
                new SeparatorMenuItem {},
                new MenuItem("Convert") {
                  onAction = e => controller.convert()
                },
                new SeparatorMenuItem {},
                new MenuItem("Return") {
                  onAction = e => switchScene()
                },
                new MenuItem("Exit") {
                  onAction = e => sys.exit(0)
                }
              )
            },
            new Menu("Edit") {
              items = Seq(
                new MenuItem("Undo") {},
                new MenuItem("Redo") {}
              )
            },
            new Menu("Help") {
              items = Seq(
                new MenuItem("GitHub") {
                  onAction = e => hostServices.showDocument("https://github.com/prolific-dev")
                }
              )
            }
          )
        },
        new SplitPane {
          vgrow = Always
          children ++= Seq(
            new AnchorPane() {
              items ++= Seq(
                new CalculateLineChart(controller)
              )
            },
            new ScrollPane() {}
          )
        }
      )
    }
  }

  override def start(): Unit =
    stage = new PrimaryStage {
      width = 800
      height = 600
      icons += new Image(getClass.getResource("/icons/icons8-g-64.png").toExternalForm)
      title = "Graham Scan - Convex Hull Calculation"
      scene = if (chartSceneIsSet) chartScene else menuScene
    }

  override def update(): Unit = start()
}
