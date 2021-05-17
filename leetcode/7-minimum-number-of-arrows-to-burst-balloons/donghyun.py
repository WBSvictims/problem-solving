from bisect import bisect


class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        s_points = sorted(points)
        s_list = [x[0] for x in s_points]
        count = 0
        min_e = -inf
        min_s = -inf
        sl = len(s_list)
        for i, coord in enumerate(s_points):
            # next start get over prev's end
            if coord[0] > min_e:
                count += 1
                min_s = coord[0]
                min_e = coord[1]
            else:
                min_e = min(min_e, coord[1])

        return count
