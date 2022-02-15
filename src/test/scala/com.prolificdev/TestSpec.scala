package `com.prolificdev`

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class TestSpec extends AnyWordSpec with Matchers{
  "A Test" when {
      "created" should {
          val test: Test = new Test()

          "have a test method" in {
              test.returnTest should be(1)
          }
      }
  }
}
