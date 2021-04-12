class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        res = x ^ y
        count = 0
        while res > 0:
            count += (res & 1)
            res >>= 1
        return count

