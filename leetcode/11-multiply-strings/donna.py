class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        def makeNum(num):
            intn, idx = 0, 0
            for n in reversed(num):
                intn += (ord(n)-ord("0"))*(10**idx)
                idx += 1
            return intn

        return str(makeNum(num1)*makeNum(num2))