package `com.prolificdev`

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class TestClassSpec extends AnyWordSpec with Matchers{
  "A Test" when {
      "created" should {
          val testClass = new TestClass()

          "have a test method" in {
              testClass.returnTest should be(1)
          }
      }
  }
}
