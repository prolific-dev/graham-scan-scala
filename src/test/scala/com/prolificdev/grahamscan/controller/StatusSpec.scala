package com.prolificdev.grahamscan.controller

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class StatusSpec extends AnyWordSpec with Matchers {
  "A Status" when {
    "called" should {
      val idle = Status.IDLE
      val saved = Status.SAVED
      val loaded = Status.LOADED

      "have a message" in {
        idle.message should be("IDLE")
        saved.message should be("DATA SAVED")
        loaded.message should be("DATA LOADED")
      }
    }
  }
}
