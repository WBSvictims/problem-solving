class Solution:
    def waysToMakeFair(self, nums: List[int]) -> int:
        numSum = sum(nums)
        odds = self.makeSums(nums[::2], False)
        evens = self.makeSums(nums[1::2], True)
        count = 0
        for i in range(len(nums)):
            minus = nums[i]
            half = 0
            if i == 0:
                half = evens[0]
            else:
                oddIdx = (i-1)//2 if (i-1)//2 < len(odds) else (i-1)//2-1
                evenIdx = (i+1)//2 if (i+1)//2 < len(evens) else (i+1)//2-1
                half = odds[oddIdx] + evens[evenIdx]
            if half*2 == numSum - minus:
                count += 1
        return count
    
    def makeSums(self, arr, isEven):
        agg = 0
        if isEven:
            for i in range(len(arr)-1, -1, -1):
                arr[i] = agg+arr[i]
                agg = arr[i]
            arr.append(0)
        else:
            for i in range(len(arr)):
                arr[i] = agg+arr[i]
                agg = arr[i]
        return arr