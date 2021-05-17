from collections import defaultdict


class Solution:
    def numSubmatrixSumTarget(self, matrix: List[List[int]], target: int) -> int:
        #  |a|b|
        #  -----
        #  |c|d|
        # d = 전체넓이 - (a+b) - (a+c) + a
        rl = len(matrix)
        cl = len(matrix[0])
        pSums = [[0] * (cl+1) for x in range(rl+1)]
        count = 0
        for i in range(0, rl):
            for j in range(0, cl):
                pSums[i+1][j+1] = pSums[i+1][j] + \
                    pSums[i][j+1] - pSums[i][j] + matrix[i][j]

        for r2 in range(0, rl):
            for r1 in range(0, r2+1):
                c = defaultdict(int)
                c[0] = 1
                for i in range(0, cl):
                    t = self.subsum(pSums, r1, 0, r2, i)
                    # print(r1, r2, i, t)
                    count += c[t - target]
                    c[t] += 1
                # print(r1, r2, c, count)

        return count

    def subsum(self, pSums, r1, c1, r2, c2):
        return pSums[r2+1][c2+1] - pSums[r1][c2+1] - pSums[r2+1][c1] + pSums[r1][c1]
