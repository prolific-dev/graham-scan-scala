package com.prolificdev.grahamscan.util

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ObserverSpec extends AnyWordSpec with Matchers {
  "An observable" when {
    "added a new observer" should {
      var updated = false
      val observable = new Observable
      val observer = new Observer {
        override def update: Unit = updated = true
      }

      "have a subscriber" in {
        observable.add(observer)
        observable.subscribers.contains(observer) should be(true)
      }
      "have subscriber removed" in {
        observable.remove(observer)
        observable.subscribers.contains(observer) should be(false)
      }
    }
  }
}
