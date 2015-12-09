import org.scalatest.{FlatSpec, ShouldMatchers}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution07 extends FlatSpec with ShouldMatchers {
  "plain recursive flatten" should "flatten a list" in {
    val list1: List[Any] = List(List(1, 1), 2, List(3, List(5, 8)))
    val list1Flattened = List(1, 1, 2, 3, 5, 8)

//    flattenWithMap(list1) should be (list1Flattened)
    flattenWithFlatmap(list1) should be (list1Flattened)
    flattenRecur(list1) should be (list1Flattened)
  }

  def flattenWithFlatmap(ls: List[Any]): List[Any] = ls flatMap {
    case internalList: List[_] => flattenWithFlatmap(internalList)
    case element => List(element)
  }

//  def flattenWithMap(ls: List[Any]): List[Any] = ls map {
//    case internalList: List[_] =>
//      flattenWithMap(internalList)
//    case element =>
//      println (s"returning $element")
//      element
//  }

  def flattenRecur(ls: List[Any]): List[Any] = ls match {
    case Nil => Nil
    case (head: List[_]) :: tail => flattenRecur(head) ++ flattenRecur(tail)
    case headItem :: tail => headItem :: flattenRecur(tail)
  }
}
