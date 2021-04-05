class Solution:
    def minAddToMakeValid(self, S: str) -> int:
        s1 = 0
        s2 = 0
        for c in S:
            if c == ")":
                if s1 > 0:
                    s1 -= 1
                else:
                    s2 += 1
            else:
                s1 += 1
        return s1 + s2
