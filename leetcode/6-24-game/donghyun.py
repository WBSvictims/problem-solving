from collections import defaultdict


class Solution:
    def judgePoint24(self, nums: List[int]) -> bool:
        # 각 숫자를 노드로 표현하면,
        # 한 노드에서 다른 노드로 가는 경우의 수 4가지
        # 곱하거나, 나누거나, 빼거나, 더하거나

        for i in range(4):
            res = nums[i]
            nums_i = nums[:i] + nums[i+1:]  # 3
            for io in range(4):
                for j in range(3):
                    nums_j = nums_i[:j] + nums_i[j+1:]  # 2
                    for p1 in range(2):
                        if p1 == 0:
                            res2 = self.oper(res, nums_i[j], io)
                        else:
                            res2 = self.oper(nums_i[j], res, io)
                        for jo in range(4):
                            for k in range(2):
                                l = 1 - k
                                for ko in range(4):
                                    res_rear = self.oper(
                                        nums_j[k], nums_j[l], ko)
                                    res_rear2 = self.oper(
                                        nums_j[l], nums_j[k], ko)
                                    if round(self.oper(res2, res_rear, jo), 5) == 24 or round(self.oper(res_rear, res2, jo), 5) == 24:
                                        return True
                                    if round(self.oper(res2, res_rear2, jo), 5) == 24 or round(self.oper(res_rear2, res2, jo), 5) == 24:
                                        return True
                                for p2 in range(2):
                                    if p2 == 0:
                                        res3 = self.oper(res2, nums_j[k], jo)
                                    else:
                                        res3 = self.oper(nums_j[k], res2, jo)

                                    for ko in range(4):
                                        if round(self.oper(res3, nums_j[l], ko), 5) == 24 or round(self.oper(nums_j[l], res3, ko), 5) == 24:
                                            return True
        return False

    def oper(self, a, b, op):
        if op == 0:
            return a + b
        elif op == 1:
            return a - b
        elif op == 2:
            if b == 0:
                return inf
            return a / b
        elif op == 3:
            return a * b
