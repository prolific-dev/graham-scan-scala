import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import com.prolificdev.model.pointComponent.pointBasicImpl.Point

class PointSpec extends AnyWordSpec with Matchers {
  "A point" when {
      "created" should {
        val p = Point(0, 0)
        "have a simple string representation" in {
          p.toString should be("(0 | 0)")
        }
      }
  }
}
