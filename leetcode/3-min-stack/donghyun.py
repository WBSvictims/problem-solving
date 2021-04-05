class MinStack:
    

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        

    def push(self, val: int) -> None:
        v, minVal = self.stack[-1] if self.stack else (None, inf)
        self.stack.append((val, min(minVal, val)))
        

    def pop(self) -> None:
        v, minVal = self.stack.pop()
        return v

    def top(self) -> int:
        v, minVal = self.stack[-1]
        return v
                          

    def getMin(self) -> int:
        v, minVal = self.stack[-1]
        return minVal
