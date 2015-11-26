import org.scalatest.{FlatSpec, ShouldMatchers}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution02 extends FlatSpec with ShouldMatchers {
  "the solution" should "find the last element of a list" in {
    penultimate(List(1, 1, 2, 3, 5, 8)) should be (5)
  }

  def penultimate(input: Seq[Int]): Int = input.init.last
}
