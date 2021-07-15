class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        while n > 1:
            n = n / 3
            if int(n) != n:
                return False
        return True if n > 0 else False