class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        n2 = len(costs)
        n = n2 // 2
        cost_sum = 0
        b_sets = costs[n:]
        a_sets = costs[:n]
        for i in range(n):
            saving_cost = 0
            switching_target = -1
            for j in range(n):
                change = b_sets[j][0] - a_sets[i][0] - \
                    (b_sets[j][1] - a_sets[i][1])
                if change < saving_cost:
                    # print(i, j)
                    saving_cost = change
                    switching_target = j
            if switching_target != -1:
                st = switching_target
                t = [b_sets[st][0], b_sets[st][1]]
                b_sets[st] = [a_sets[i][0], a_sets[i][1]]
                a_sets[i] = t

        for i in range(n):
            cost_sum += (a_sets[i][0] + b_sets[i][1])
        return cost_sum
