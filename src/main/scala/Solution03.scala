import org.scalatest.{FlatSpec, ShouldMatchers}

import scala.util.{Failure, Success, Try}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution03 extends FlatSpec with ShouldMatchers {
  "the solution" should "find the kth element in a list first element is indexed 0" in {
    val list = List(1, 1, 2, 3, 5, 8)
    val k = 2

    kth(list, k) should be (Success(2))

    kthRecur(list, k) should be (Success(2))
  }

  def kth(input: Seq[Int], kthIndex: Int): Try[Int] = Success(input.drop(kthIndex).head)

  def kthRecur(input: Seq[Int], kthIndex: Int): Try[Int] = kthIndex match {
    case k if k > 0 => kthRecur(input.drop(1), k - 1)
    case k if k == 0 => Success(input.head)
    case _ => Failure[Int](new NoSuchElementException("No such element")) // how to avoid inferred type containing nothing.
  }
}
