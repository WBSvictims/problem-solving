class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        bx = bin(x)[2:].zfill(31)
        by = bin(y)[2:].zfill(31)
        ham = 0
        for i in range(len(bx)):
            if bx[i] != by[i]:
                ham += 1
        return ham