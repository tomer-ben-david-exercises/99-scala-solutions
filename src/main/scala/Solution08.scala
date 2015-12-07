import org.scalatest.{FlatSpec, ShouldMatchers}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution08 extends FlatSpec with ShouldMatchers {
  "compress" should "Eliminate consecutive duplicates of list elements" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

    compress(list) should be (List('a, 'b, 'c, 'a, 'd, 'e))
  }

  def compress(ls: List[Symbol]): List[Symbol] = ls match {
    case Nil => Nil
    case headItem :: Nil => List(headItem)
    case item1 :: item2 :: tail if item1 == item2 => compress(item2 :: tail)
    case item1 :: item2 :: tail => item1 :: compress(item2 :: tail)
  }
}
