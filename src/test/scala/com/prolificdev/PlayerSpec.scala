import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class PlayerSpec extends AnyWordSpec with Matchers {
  "A player" when {
      "created" should {
        val p = Player("Dennis")
          "have a name" in {
            p.name should be("Dennis")
          }
      }
  }
}
