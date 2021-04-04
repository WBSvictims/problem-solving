class Solution:
    def removeDuplicates(self, S: str) -> str:
        ret = ""
        for i in range(len(S)):
            if ret[-1:] == S[i]:
                ret = ret[:-1]
            else:
                ret += S[i]
        return ret