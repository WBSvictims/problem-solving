class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        [small, big] = sorted([m-1, n-1])
        ret = 1
        if small == 0: return 1
        for idx in range(small):
            ret *= big+1+idx
        
        def factorial(n):
            fact = 1
            while n > 1:
                fact *= n
                n -= 1
            return fact
        return ret//factorial(small)