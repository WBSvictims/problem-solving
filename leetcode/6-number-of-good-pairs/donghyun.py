class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        count = 0
        for i, num in enumerate(nums):
            count += len([x for x in nums[i+1:] if x == num])
        return count
