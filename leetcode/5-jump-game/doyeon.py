class Solution:
    def canJump(self, nums: List[int]) -> bool:
        numLength = len(nums)
        bigNum = nums[0]
        for i in range(len(nums)):
            if nums[i] > bigNum:
                bigNum = nums[i]
            elif bigNum == 0 and i < len(nums)-1:
                return False
            bigNum -= 1
        return True