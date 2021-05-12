import heapq
class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort()
        prev = [-float("inf"), -float("inf")]
        candi = []
        print(points)
        for start, end in points:
            if start <= prev[1]:
                heapq.heappop(candi)
                prev = [start, prev[1] if end > prev[1] else end]
            else:
                prev = [start, end]
            heapq.heappush(candi, prev)
        return len(candi)