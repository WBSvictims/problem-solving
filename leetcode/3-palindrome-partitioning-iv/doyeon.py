class Solution:
    def checkPartitioning(self, s: str) -> bool:
        def isPel(t):
            return t == t[::-1]
    
        @lru_cache(None)
        def into(arr, piece):
            if piece == 1: return isPel(arr)
            for i in range(len(arr)-piece+1):
                if isPel(arr[:i+1]) and into(arr[i+1:], piece-1):
                    return True
        
        return into(s, 3)