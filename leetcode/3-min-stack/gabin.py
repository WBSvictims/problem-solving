class MinStack:

    def __init__(self):
        self.stack = []
        return None
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        return None

    def pop(self) -> None:
        last_val = self.stack[-1]
        self.stack = self.stack[:-1]
        return last_val

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return min(self.stack)
        