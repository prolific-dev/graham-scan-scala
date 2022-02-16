package com.prolificdev.model.fileIoComponent

trait FileIOInterface {
    def load: Unit

    def save: Unit
}
