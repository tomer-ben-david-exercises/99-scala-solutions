import org.scalatest.{ShouldMatchers, FlatSpec}

import scala.util.{Failure, Success, Try}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution01 extends FlatSpec with ShouldMatchers {
  "the solution" should "find the last element of a list" in {
    last(List(1, 1, 2, 3, 5, 8)) should be (8)
    lastWithRecursion(List(1, 1, 2, 3, 5, 8)) should be (Success(8))
  }

  def last(input: Seq[Int]): Int = input.last

  def lastWithRecursion(input: Seq[Int]): Try[Int] = input match {
      case head :: Nil => Success(head)
      case _ :: tail => lastWithRecursion(tail)
      case _ => Failure(new NoSuchElementException("No such element")) // how to avoid inferred type containing nothing.
  }
}
