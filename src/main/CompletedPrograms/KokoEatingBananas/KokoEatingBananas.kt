package KokoEatingBananas
    fun main() {
        val solution = Solution()

        val piles = intArrayOf(3, 6, 7, 11)
        val h = 8

        val result = solution.minEatingSpeed(piles, h)

        println("Koko can eat $result bananas in $h hours.")
    }


class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var max = 0
        for(pile in piles){
            max = maxOf(max, pile)
        }
        var right = max

        while(left < right){
            val mid = left + (right - left) /2

            if(canEat(piles, h, mid)){
                right = mid
            }else{
                left = mid + 1
            }
        }

        return left
    }

    private fun canEat(piles: IntArray, h: Int, k: Int): Boolean{
        var hours = 0

        for(pile in piles){
            hours += (pile + k - 1) / k
        }

        return hours <= h
    }
}
