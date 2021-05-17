class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        inbounds = [0] * 1001
        outbounds = [0] * 1001
        for p in trust:
            inbounds[p[1]] += 1
            outbounds[p[0]] += 1
        judge_cand = -1
        for i in range(1, n+1):
            if inbounds[i] == n - 1 and outbounds[i] == 0:
                if judge_cand == -1:
                    judge_cand = i
                else:
                    return -1
        return judge_cand
