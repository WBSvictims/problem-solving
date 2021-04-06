class Solution:
    def waysToMakeFair(self, nums: List[int]) -> int:
        length = len(nums)
        odd_sum = 0
        even_sum = 0
        result = 0
        odd_sum_list = [0 for _ in range(length)]
        even_sum_list = [0  for _ in range(length)]
        for i, v in enumerate(nums):
            if i%2 == 1:
                odd_sum += v 
            else:
                even_sum += v
            odd_sum_list[i] = odd_sum
            even_sum_list[i] = even_sum
        for i in range(length):
            current_back_odd_sum = even_sum - even_sum_list[i]
            current_back_even_sum = odd_sum - odd_sum_list[i]
            
            if i > 0:
                if current_back_odd_sum + odd_sum_list[i - 1] == current_back_even_sum + even_sum_list[i - 1]:
                    result += 1
            else:
                if current_back_odd_sum == current_back_even_sum:
                    result += 1
        return result