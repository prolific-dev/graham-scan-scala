package com.prolificdev.grahamscan

import com.google.inject.AbstractModule
import com.prolificdev.grahamscan.model.calculateComponent.calculateBasicImpl.Calculate
import com.prolificdev.grahamscan.model.calculateComponent.CalculateInterface
import com.prolificdev.grahamscan.model.fileIoComponent.fileIoJsonImpl.FileIO
import com.prolificdev.grahamscan.model.fileIoComponent.FileIoInterface
import com.prolificdev.grahamscan.util.Point

class GrahamScanModule extends AbstractModule {


  override def configure: Unit = {
    bind(classOf[CalculateInterface]).toInstance(Calculate(Vector(Point(0, 0))))
    bind(classOf[FileIoInterface]).to(classOf[FileIO])
  }
}
