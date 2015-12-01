import org.scalatest.{FlatSpec, ShouldMatchers}

import scala.annotation.tailrec
import scala.util.{Success, Try}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution05 extends FlatSpec with ShouldMatchers {
  "the solution" should "reverse the list" in {
    val list = List(1, 1, 2, 3, 5, 8)

    reverse(list) should be (List(8,5,3,2,1,1))
  }

  private def reverse(list: Seq[Int]): Seq[Int] = list match {
    case head :: tail => reverse(tail) :+ head
    case _ => list
  }


}
