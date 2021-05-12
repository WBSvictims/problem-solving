class Solution:
    def wordSubsets(self, A: List[str], B: List[str]) -> List[str]:
        # B의 모든 string map union하기
        # A 하나씩 훑으면서 조건 맞는것 고르기
        universal_map = {}
        for b in B:
            t = {}
            for c in b:
                t[c] = t.get(c, 0) + 1
            for k, v in t.items():
                universal_map[k] = max(universal_map.get(k, 0), v)
        # print(universal_map)
        res = []
        for a in A:
            t = {}
            for c in a:
                t[c] = t.get(c, 0) + 1
            for k, v in universal_map.items():
                if t.get(k, 0) < v:
                    break
            else:
                res.append(a)
        return res
