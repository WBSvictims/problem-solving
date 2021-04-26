class Solution:
    def canJump(self, nums: List[int]) -> bool:
        l = len(nums)
        min_range = l - 1
        for i, mj in enumerate(nums[::-1]):
            i = l - 1 - i
            if min_range <= i + mj:
                min_range = i
        return min_range == 0
