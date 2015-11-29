import org.scalatest.{FlatSpec, ShouldMatchers}

import scala.util.{Failure, Success, Try}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution04 extends FlatSpec with ShouldMatchers {
  "the solution" should "find the number of items in a list" in {
    val list = List(1, 1, 2, 3, 5, 8)

    sizeRecur(list, 0) should be (Success(list.size))
  }

  def sizeRecur(input: Seq[Int], curSize: Int): Try[Int] = input match {
    case Nil => Success(curSize)
    case _ => sizeRecur(input.tail, curSize + 1)
  }
}
