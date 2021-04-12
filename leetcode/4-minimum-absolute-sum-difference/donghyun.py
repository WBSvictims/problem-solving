import bisect

class Solution:
    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:
        # nums1을 정렬
        # diff_nums = abs(nums1 - nums2)
        # max_diff_nums = nums1 각각을 nums2와 가장 차이 적은걸로 교체했을때 변하는 diff값
        # sum(diff_nums) - max(max_diff_nums)
        diff_nums = [abs(a - b) for a, b in zip(nums1, nums2)]
        sorted_nums1 = sorted(nums1)
        # print(sorted_nums1)
        max_diff_nums = [diff_nums[i] - self.find_min_diff(x, sorted_nums1) for i, x in enumerate(nums2)]
        return (sum(diff_nums) - max(max_diff_nums)) % int(1e9 + 7)
        
    def find_min_diff(self, x, nums):
        i = bisect.bisect(nums, x)
        if i == len(nums) or i > 0 and abs(nums[i-1] - x) < abs(nums[i] - x):
            return abs(nums[i-1] - x)
        else:
            return abs(nums[i] - x)

