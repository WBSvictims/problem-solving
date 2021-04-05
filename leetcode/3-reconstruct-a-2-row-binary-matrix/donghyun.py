class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        l = len(colsum)
        res = [[0] * l for x in range(2)]
        for i, s in enumerate(colsum):
            if s == 2:
                if upper == 0 or lower == 0:
                    # print(res, upper, lower)
                    return []
                res[0][i] = res[1][i] = 1
                upper -= 1
                lower -= 1
            elif s == 1:
                if upper + lower == 0:
                    # print(res, upper, lower)
                    return []
                elif upper == 0 or lower > upper:
                    res[1][i] = 1
                    lower -= 1
                else:
                    res[0][i] = 1
                    upper -= 1
        if not upper == lower == 0:
            return []
        return res
