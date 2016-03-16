object Hello {
    def main(args: Array[String]) {
        println(findAllPerms(List(0,0)))   
    }
    
    def findAllPerms(phone: List[Int]): List[List[String]] = {
        if (phone == Nil) {
            return List(List[String]())
        } else if (phone.length == 1) {
            return findSingleDigitPerms(phone(0))
            
        } else {
            val finalList = new scala.collection.mutable.ListBuffer[List[String]]()
            val firstDigitPerms = findAllPerms(List(phone.head))
            val otherPerms = findAllPerms(phone.tail)
            for (firstPerm <- firstDigitPerms) {
                for (otherPerm <- otherPerms) {
                    finalList += firstPerm ++ otherPerm
                }
            }
            return finalList.toList
        }

    }
                        
    def findSingleDigitPerms(digit: Int): List[List[String]] = {
        if (digit == 0) {
            return List(List("a"), List("b"), List("c"))
        } else {
            return List(List("d"), List("e"), List("f"))
        }
    }
}
