import org.scalatest.{FlatSpec, ShouldMatchers}

/**
 * @author tomerb
 * on 26/11/15
 */
//noinspection ScalaStyle
class Solution06 extends FlatSpec with ShouldMatchers {
  "the solution" should "detect a palindrome" in {
    val notPalindrome = List(1, 1, 2, 3, 5, 8)
    val palindrome = List(1, 2, 3, 2, 1)

    isPalindrome(notPalindrome) should not be true
    isPalindrome(palindrome) should be (true)
  }

  private def isPalindrome(list: Seq[Int]): Boolean = list match {
    case singleItem :: Nil => true
    case head :: tail => (head == tail.last) && isPalindrome(tail.dropRight(1))
    case _ => true
  }


}
