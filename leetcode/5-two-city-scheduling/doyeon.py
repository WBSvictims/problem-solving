class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        costs.sort(key=lambda x: x[0]-x[1])
        halfIdx = len(costs)//2-1
        total = 0
        for i in range(len(costs)):
            if i <= halfIdx:
                total += costs[i][0]
            else:
                total += costs[i][1]
        return total