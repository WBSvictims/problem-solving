class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        size = len(costs)
        for item in costs:
            item.append(item[0] - item[1])
        sorted_costs = sorted(costs, key=lambda x: x[2])
        res = 0
        for i in range(int(size/2)):
            res += sorted_costs[i][0]
            res += sorted_costs[size - i - 1][1]
        return res