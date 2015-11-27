import org.scalatest.{FlatSpec, ShouldMatchers}

import scala.util.{Success, Try, Failure}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution02 extends FlatSpec with ShouldMatchers {
  "the solution" should "find the last element of a list" in {
    penultimate(List(1, 1, 2, 3, 5, 8)) should be (Success(5))
    penultimateRecur(List(1, 1, 2, 3, 5, 8)) should be (Success(5))
  }

  def penultimate(input: Seq[Int]): Try[Int] = Success(input.init.last)

  def penultimateRecur(input: Seq[Int]): Try[Int] = input match {
    case prevTail :: tail :: Nil => Success(prevTail)
    case head :: tail => penultimateRecur(tail)
    case _ => Failure[Int](new NoSuchElementException("No such element")) // how to avoid inferred type containing nothing.
  }
}
