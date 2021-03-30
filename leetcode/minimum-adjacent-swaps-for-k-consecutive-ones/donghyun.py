class Solution:
    def minMoves(self, nums: List[int], k: int) -> int:
        numbers = [i for i, zero_or_one in enumerate(nums) if zero_or_one == 1]
        pSum = list(self.scan(lambda p, acc: p + acc, 0, numbers))
        min_val = min((pSum[i + k] - pSum[i + (k+1)//2]) -
                      (pSum[i + k//2] - pSum[i]) for i in range(len(numbers) - k + 1))
        return min_val - (k//2) * ((k+1)//2)

    def scan(self, f, state, it):
        yield state
        for x in it:
            state = f(state, x)
            yield state
