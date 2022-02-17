package com.prolificdev.grahamscan

import com.google.inject.AbstractModule
import com.prolificdev.grahamscan.controller.controllerComponent.ControllerInterface
import com.prolificdev.grahamscan.controller.controllerComponent.controllerBasicImpl.Controller
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.model.calculateComponent.calculateBasicImpl.Calculate
import com.prolificdev.grahamscan.model.fileIoComponent.FileIOInterface
import com.prolificdev.grahamscan.model.fileIoComponent.fileIoJsonImpl.FileIO
import com.prolificdev.grahamscan.model.geometryComponent.GeometryInterface
import com.prolificdev.grahamscan.model.geometryComponent.geometryBasicImpl.Geometry

class GrahamScanModule extends AbstractModule {

  override def configure: Unit = {
    bind(classOf[FileIOInterface]).to(classOf[FileIO])
    bind(classOf[CalculateInterface]).to(classOf[Calculate])
    bind(classOf[GeometryInterface]).to(classOf[Geometry])
    bind(classOf[ControllerInterface]).to(classOf[Controller])
  }
}
