import bisect


class Solution:
    def findLatestStep(self, arr: List[int], m: int) -> int:
        pmap = {1: len(arr)}
        # print(pmap, arr)
        if len(arr) == m:
            return len(arr)
        for i, num in enumerate(arr[::-1]):
            if self.process(pmap, num, m):
                return len(arr) - i - 1
            if pmap and max(pmap.values()) < m:
                return -1
        return -1

    def process(self, pmap, num, m):
        keys = sorted(list(pmap.keys()))
        lk = bisect.bisect(keys, num)
        l = keys[lk-1]
        if l + pmap[l] - 1 > num:
            pmap[num + 1] = l + pmap[l] - 1 - num
        if l < num:
            pmap[l] = num - l
        else:
            del pmap[l]
        # print(pmap)

        return num - l == m or (num+1 in pmap and pmap[num + 1] == m)
