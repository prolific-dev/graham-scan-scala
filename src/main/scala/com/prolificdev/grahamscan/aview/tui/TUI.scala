package com.prolificdev.grahamscan.aview.tui

import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface
import com.prolificdev.grahamscan.util.Observer

class TUI(controller: ControllerInterface) extends Observer {
  controller.add(this)

  override def update: Unit = ???

}
