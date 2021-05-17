from itertools import combinations


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        n = len(s)
        if n > 12:
            return []
        # pos = s[1] ~ s[n]
        combs = combinations(range(1, n), 3)
        # print(list(combs))
        res = []
        for comb in combs:
            cand = self.convertToList(s, comb)
            # print(comb, cand)
            if self.checkValidIpAddr(cand):
                res.append('.'.join(cand))

        return res

    def convertToList(self, s, comb):
        return [s[0:comb[0]], s[comb[0]:comb[1]], s[comb[1]:comb[2]], s[comb[2]:]]

    def checkValidIpAddr(self, ipAddr):
        for d in ipAddr:
            if not self.check(d):
                return False
        return True

    def check(self, d):
        if d[0] == "0" and len(d) > 1:
            return False
        if 0 <= int(d) <= 255:
            return True
        return False
