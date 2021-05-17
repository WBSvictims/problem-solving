import heapq


class Solution:
    digits_f = {"1": "2", "2": "3", "3": "4", "4": "5", "5": "6",
                "6": "7", "7": "8", "8": "9", "9": "0", "0": "1"}
    digits_r = {y: x for x, y in digits_f.items()}

    def openLock(self, deadends: List[str], target: str) -> int:
        # DFS, but should not go to already discovered and deadends
        discovered = {x: 1 for x in deadends}
        # print(discovered)
        pq = []
        heapq.heappush(pq, (0, "0000"))
        while pq:
            count, nums = heapq.heappop(pq)
            # print(count, nums)
            if nums == target:
                return count
            if nums in discovered:
                continue
            discovered[nums] = 1
            for i in range(4):
                for is_rear in range(2):
                    changed_nums = nums[:i] + \
                        self.change_num(nums[i], is_rear) + nums[i+1:]
                    if not changed_nums in discovered:
                        heapq.heappush(pq, (count + 1, changed_nums))
        return -1

    def change_num(self, c, is_rear):
        if is_rear:
            return self.digits_r[c]
        else:
            return self.digits_f[c]
