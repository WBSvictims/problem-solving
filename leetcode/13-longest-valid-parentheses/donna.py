class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if s == "": return 0
        q = [(0, s[0])]
        ret, cur = [], None
        for i in range(1, len(s)):
            if q != [] and q[-1][1] == "(" and s[i] == ")":
                sidx, _ = q.pop()
                cur = (sidx, i)
                if i == len(s)-1: ret.append(cur)
            else:
                if cur is not None:
                    ret.append(cur)
                    cur = None
                q.append((i, s[i]))
        
        if ret == []: return 0
        if len(ret) == 1: return ret[0][1]-ret[0][0]+1
        
        prev = ret[0]
        merged = []
        for i in range(1, len(ret)):
            start, end = ret[i]
            if prev[1]+1 >= start:
                end = end if end > prev[1] else prev[1]
                prev = (prev[0], end)
                if i == len(ret)-1: merged.append(prev[1]-prev[0]+1)
            else:
                if merged == [] or (merged[-1] != (prev[1]-prev[0]+1)):
                    merged.append(prev[1]-prev[0]+1)
                if i == len(ret)-1 and (merged[-1] != end-start+1):
                    merged.append(end-start+1)
                prev = ret[i]
        
        return max(merged)