class Solution:
    def removeDuplicates(self, S: str) -> str:
        while True:
            new_S = self.removePalindrome(S)
            if S == new_S:
                return S
            else:
                S = new_S

    def removePalindrome(self, S):
        for i, c in enumerate(S):
            if i > 0 and S[i-1] == c:
                k = self.find_palindrome_size(S, i)
                l = i-1-k
                r = i+1+k
                return S.replace(S[l:r], '')
        return S

    def find_palindrome_size(self, S, i):
        for k in range(0, min(i, len(S) - i)):
            if S[i-1-k] != S[i+k]:
                return k-1
        return min(i, len(S) - i) - 1
