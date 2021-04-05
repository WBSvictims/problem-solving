class Solution:
    def waysToMakeFair(self, nums: List[int]) -> int:
        oddSum = [0]
        evenSum = [0]
        l = len(nums)
        for i, v in enumerate(nums[::-1]):
            if (l - i - 1) % 2 == 1:
                oddSum.append(oddSum[-1] + v)
                evenSum.append(evenSum[-1])
            else:
                evenSum.append(evenSum[-1] + v)
                oddSum.append(oddSum[-1])
        oddSum = oddSum[::-1]
        evenSum = evenSum[::-1]
        res = 0
        for i in range(l):
            if (evenSum[0] - evenSum[i] + oddSum[i + 1]) == (oddSum[0] - oddSum[i] + evenSum[i+1]):
                res += 1
        return res
