class LRUCache {
  capacity
  cacheMap

  constructor(capacity: number) {
    this.capacity = capacity
    this.cacheMap = new Map()
  }

  get(key: number): number {
    const value = this.cacheMap.get(key)

    if (value !== undefined) {
      this.cacheMap.delete(key)
      this.cacheMap.set(key, value)
    }

    return value === undefined ? -1 : value
  }

  put(key: number, value: number): void {
    if (this.cacheMap.has(key)) {
      this.cacheMap.delete(key)
    } else if (this.cacheMap.size >= this.capacity) {
      this.cacheMap.delete(this.cacheMap.keys().next().value)
    }
    this.cacheMap.set(key, value)
  }
}

/**
* Your LRUCache object will be instantiated and called as such:
* var obj = new LRUCache(capacity)
* var param_1 = obj.get(key)
* obj.put(key,value)
*/