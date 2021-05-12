from collections import defaultdict

class Solution:
    def wordSubsets(self, A: List[str], B: List[str]) -> List[str]:
        bs = set()
        dups = defaultdict(int)
        for item in B:
            words = list(item)
            for w in words:
                wcount = words.count(w)
                if wcount > 1 and dups[w] < wcount:
                    dups[w] = wcount
            bs.update(words)
        
        ret = []
        for item in A:
            if bs.issubset(set(item)):
                have_dups = True
                for dupw in dups.keys():
                    dupcount = dups[dupw]
                    if item.count(dupw) < dupcount:
                        have_dups = False
                        break
                if have_dups:
                    ret.append(item)
        return ret