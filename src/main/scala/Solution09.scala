import org.scalatest.{FlatSpec, ShouldMatchers}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution09 extends FlatSpec with ShouldMatchers {
  "pack" should "If a list contains repeated elements they should be placed in separate sublists" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val packedList = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

    pack(list) should be (packedList)
  }

  def pack(ls: List[Any]): List[Any] = ls match {
    case Nil => Nil
    case List() => List()
    case _ =>
      val (packed, theRest) = ls span { _ == ls.head }
      packed :: pack(theRest)
  }


}
