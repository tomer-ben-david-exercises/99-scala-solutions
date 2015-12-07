import org.scalatest.{FlatSpec, ShouldMatchers}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution08 extends FlatSpec with ShouldMatchers {
  "compress" should "Eliminate consecutive duplicates of list elements" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

    compressRecur(list) should be (List('a, 'b, 'c, 'a, 'd, 'e))
    compressFold(list) should be (List('a, 'b, 'c, 'a, 'd, 'e))
  }

  def compressFold(ls: List[Symbol]): List[Symbol] = ls.foldRight(List[Symbol]())((item,list) => {
    if (list.isEmpty || list.head != item) item :: list
    else list
  })
  def compressRecur(ls: List[Symbol]): List[Symbol] = ls match {
    case Nil => Nil
    case headItem :: Nil => List(headItem)
    case item1 :: item2 :: tail if item1 == item2 => compressRecur(item2 :: tail)
    case item1 :: item2 :: tail => item1 :: compressRecur(item2 :: tail)
  }
}
