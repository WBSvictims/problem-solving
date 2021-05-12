class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        left = [x for x in nums if x > nums[0]]
        right = [x for x in nums if x < nums[0]]
        mid = [x for x in nums if x == nums[0]]
        
        if k > len(left)+len(mid):
            return self.findKthLargest(right, k-len(left)-len(mid))
        elif k <= len(left):
            return self.findKthLargest(left, k)
        else:
            return mid[0]