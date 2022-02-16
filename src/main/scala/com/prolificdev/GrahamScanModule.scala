package com.prolificdev

import com.google.inject.AbstractModule
import com.prolificdev.model.fileIoComponent.FileIO
import com.prolificdev.model.fileIoComponent.FileIOInterface
import com.prolificdev.model.pointComponent.pointBasicImpl.Point

class GrahamScanModule extends AbstractModule {

  override def configure: Unit = {
    bind(classOf[FileIOInterface]).to(classOf[FileIO])
  }
}
