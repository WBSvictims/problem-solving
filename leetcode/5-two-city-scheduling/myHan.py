class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        N = len(costs) // 2
        memoization = [[0] + [0x3f3f3f3f] * (2 * N)] + [[0x3f3f3f3f for _ in range(2 * N + 1)] for _ in range(2 * N)]
        
        for i in range(1, 2 * N+1):
            memoization[i][0] = memoization[i-1][0] + costs[i-1][0]
            for j in range(1, min(i, N)+1):
                memoization[i][j] = min(memoization[i-1][j] + costs[i-1][0], memoization[i-1][j-1] + costs[i-1][1])
                
        # print(*memoization, sep="\n")
        
        return memoization[2 * N][N]
