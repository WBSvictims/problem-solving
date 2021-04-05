class Solution:
    def checkPartitioning(self, s: str) -> bool:
        # s가 3개의 palindrome으로 나눠지는지
        # 1글자는 무조건 펠린드롬
        # 2개의 막대기가 존재. 각각 어디에 꽂을것인가
        # dp[start][end] = True of false. dp를 어떻게 완성?
        # dp[i][i] = True
        # dp[i][i+1] = s[i] == s[i+1]
        # dp[i][i+2] = dp[i+1][i+1] and s[i] == s[i+2]
        # dp[i][i+3] = dp[i+1][i+2] and s[i] == s[i+3]
        l = len(s)
        dp = [[False] * l for x in range(l)]
        for i in range(l):
            dp[i][i] = True
        for j in range(1, l-1):
            for i in range(l-j):
                # print(i, j, l)
                dp[i][i+j] = dp[i+1][max(i+j-1, i+1)] and s[i] == s[i+j]
        # print(dp)
                
        for i in range(0, l):
            for j in range(i+1, l-1):
                # print(0, i, j, l)
                if dp[0][i] and dp[i+1][j] and dp[j+1][l-1]:
                    return True
        return False
