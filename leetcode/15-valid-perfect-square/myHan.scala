object Square {
    def unapply(x: Int): Option[Int] = {
        var (bot, top) = (1L, x.toLong)
        while(bot + 1 < top) {
            val mid = (bot + top) / 2
            if(x < mid * mid) top = mid else bot = mid
        }
        return if(bot * bot == x) Some(bot.toInt) else None
    }
}
object Solution {
    def isPerfectSquare(num: Int): Boolean = {
        return num match {
            case Square(_) => true
            case _ => false
        }
    }
}