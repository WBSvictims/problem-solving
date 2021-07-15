class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.data = {}
        self.history = []

    def get(self, key: int) -> int:
        ret = self.data.get(key, -1)
        if ret != -1:
            self.add_history(key)
        return ret

    def put(self, key: int, value: int) -> None:
        self.add_history(key)
        self.data[key] = value
    
    def add_history(self, key):
        if key in self.history:
            self.history.remove(key)
        self.history.append(key)
        if len(self.history) > self.capacity:
            evicted_key = self.history.pop(0)
            self.data[evicted_key] = -1


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)