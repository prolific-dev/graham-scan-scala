package com.prolificdev

import com.google.inject.AbstractModule
import com.prolificdev.model.fileIoComponent.FileIOInterface
import com.prolificdev.model.fileIoComponent.fileIoJsonImpl.FileIO


class GrahamScanModule extends AbstractModule {

  override def configure: Unit = {
    bind(classOf[FileIOInterface]).to(classOf[FileIO])
  }
}
