package com.prolificdev.grahamscan.aview.gui.filechooser

import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.stage.FileChooser
import scalafx.stage.FileChooser.ExtensionFilter
import scalafx.Includes.*

import java.io.File
import scala.util.{Failure, Success, Try}

class CalculateFileChooser extends FileChooser {
  initialDirectory = new File(System.getProperty("user.home"))

  def loadFile(stage: PrimaryStage): Try[File] =
    this.title = "Load File"
    this.extensionFilters.clear()
    this.extensionFilters += ExtensionFilter("JSON", "*.json")

    Try(this.showOpenDialog(stage))

  def saveFile(stage: PrimaryStage): Try[File] =
    this.title = "Save File"
    this.extensionFilters.clear()
    this.extensionFilters += ExtensionFilter("JSON", "*.json")

    Try(this.showSaveDialog(stage))

  def convertFile(stage: PrimaryStage): Try[File] =
    this.title = "Convert File"
    this.extensionFilters.clear()
    this.extensionFilters += ExtensionFilter("TXT", "*.txt")

    Try(this.showOpenDialog(stage))
}
