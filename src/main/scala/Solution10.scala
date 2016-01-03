import org.scalatest.{FlatSpec, ShouldMatchers}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution10 extends FlatSpec with ShouldMatchers {
  "encode" should "Run-length encoding of a list" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val encoded = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

    encode(list) should be (encoded)
    encodeWithPack(list) should be (encoded)
  }

  def encodeWithPack(ls: List[_]): List[_] = {
    val packed = new Solution09().pack(ls)
    packed.map(sameInternalList => (sameInternalList.size, sameInternalList.head))
  }

  def encode(ls: List[_]): List[_] = {
    def encodeInternal(encodedSoFar: List[_], leftToEncode: List[_]): List[_] = {
      leftToEncode match {
        case Nil => encodedSoFar
        case _ =>
          val (similarToHead, rest) = leftToEncode.span(_ == leftToEncode.head)
          val encodedSoFarWithNew = encodedSoFar :+ (similarToHead.size, similarToHead.head)
          encodeInternal(encodedSoFarWithNew, rest)
      }
    }
    encodeInternal(Nil, ls)
  }

}
