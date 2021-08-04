import scala.language.postfixOps

object Solution {
    def maximumGap(nums: Array[Int]): Int = {
        var order = 0 until nums.size toArray
        
        for(lb <- 0 until 30 by 6) {
            val pat = (1 << (lb + 6)) - 1
            val count = Array.fill[Int](1<<6)(0)
            for(i <- order) {
                count((pat & nums(i)) >> lb) += 1
            }
            
            for(i <- 1 until count.size) {
                count(i) += count(i-1)
            }
            val nOrder = new Array[Int](order.size)
            for(i <- order.size-1 to 0 by -1) {
                count((nums(order(i)) & pat) >> lb) -= 1
                nOrder(count((nums(order(i)) & pat) >> lb)) = order(i)
            }
            order = nOrder
        }
        
        var ret = 0
        for(i <- 0 until order.size-1) {
            ret = ret max (nums(order(i+1)) - nums(order(i)))
        }
        ret
    }
}