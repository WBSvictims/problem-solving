class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        before, after = nums[:], nums[:]
        for i in range(1, len(nums)):
            if nums[i-1] > nums[i]:
                after[i-1] = nums[i]
                before[i] = nums[i-1]
                return after == sorted(after) or before == sorted(before)
        return True