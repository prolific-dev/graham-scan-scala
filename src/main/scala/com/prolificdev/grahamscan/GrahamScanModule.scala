package com.prolificdev.grahamscan

import com.google.inject.AbstractModule
import com.prolificdev.grahamscan.controller.controllerComponent.controllerBasicImpl.Controller
import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface

class GrahamScanModule extends AbstractModule {

  override def configure: Unit = {
    bind(classOf[ControllerInterface]).to(classOf[Controller])
  }
}
