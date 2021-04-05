class Solution:
    def minAddToMakeValid(self, S: str) -> int:
        fore = ""
        counts = 0
        for i in range(len(S)):
            if fore[-1:] == "(" and S[i] == ")":
                counts += 1
                fore = fore[:-1]
            else:
                fore += S[i]
        return len(fore)