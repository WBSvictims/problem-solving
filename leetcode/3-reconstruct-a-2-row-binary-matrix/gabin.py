class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        dp = [[0] * len(colsum) for i in range(2)]
        for i in range(len(colsum)):
            if colsum[i] == 0:
                dp[0][i] = dp[1][i] = 0
            if colsum[i] == 2:
                dp[0][i] = dp[1][i] = 1
                upper -= 1
                lower -= 1
        for i in range(len(colsum)):
            if colsum[i] == 2 or colsum[i] == 0: continue
            if dp[0][i] == 0 and upper > 0:
                dp[0][i] = 1
                upper -= 1
            elif dp[1][i] == 0 and lower > 0:
                dp[1][i] = 1
                lower -= 1
            else:
                return []
        return dp if upper == 0 and lower == 0 else []