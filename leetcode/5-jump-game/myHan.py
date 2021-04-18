class Solution:
    def canJump(self, nums: List[int]) -> bool:
        reach = 0
        for i, v in enumerate(nums):
            if reach < i:
                break
            reach = max(reach, i + v)
        
        return len(nums) <= reach + 1