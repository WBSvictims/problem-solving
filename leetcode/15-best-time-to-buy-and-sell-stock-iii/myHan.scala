object Solution {
    def maxProfit(prices: Array[Int]): Int = {
        val maxPriceFromRight = Array.fill(prices.size + 1)(0)
        val minPriceFromLeft = Array.fill(prices.size + 1)(100001)
        for(i <- prices.size to 1 by -1) {
            maxPriceFromRight(i-1) = maxPriceFromRight(i) max prices(i-1)
        }
        for(i <- 0 until prices.size) {
            minPriceFromLeft(i+1) = minPriceFromLeft(i) min prices(i)
        }
        var leftMax = 0
        var totalMax = 0
        for(i <- 0 until prices.size) {
            leftMax = if(0 <= i-1) {leftMax max (prices(i-1) - minPriceFromLeft(i-1))} else leftMax
            totalMax = totalMax max (leftMax + maxPriceFromRight(i+1) - prices(i))
        }
        totalMax
    }
}