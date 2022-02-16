package com.prolificdev

import com.google.inject.AbstractModule
import com.prolificdev.model.pointComponent.PointInterface
import com.prolificdev.model.pointComponent.pointBasicImpl.Point
import com.prolificdev.model.fileIoComponent.FileIOInterface
import com.prolificdev.model.fileIoComponent.FileIO

class GrahamScanModule extends AbstractModule {

    override def configure: Unit = {
        bind(classOf[PointInterface]).to(classOf[Point])
        bind(classOf[FileIOInterface]).to(classOf[FileIO])
    }
}
