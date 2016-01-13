import org.scalatest.{FlatSpec, ShouldMatchers}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution11 extends FlatSpec with ShouldMatchers {
  "encode" should "Run-length encoding of a list" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val encodedModified = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

    encodeModified(list) should be (encodedModified)
  }

  def encodeModified(ls: List[_]): List[Any] = {
    new Solution10().encode(ls).map(x => x match {
      case (count, char) if count == 1 => char
      case _ => x
    })
  }

}
