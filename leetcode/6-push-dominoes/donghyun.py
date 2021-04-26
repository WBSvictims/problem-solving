class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        # two pointers
        dominoes = 'L' + dominoes + 'R'
        s, e = 0, 0
        res = list(dominoes)
        for e, c in enumerate(dominoes):
            if c == 'L':
                if dominoes[s] == 'R':
                    for r in range(s, e):
                        # print (r)
                        mid = (s + e) / 2
                        if r < mid:
                            res[r] = 'R'
                        elif r > mid:
                            res[r] = 'L'
                else:
                    for r in range(s, e):
                        res[r] = 'L'
                s = e
            elif c == 'R':
                if dominoes[s] == 'R':
                    for r in range(s, e):
                        res[r] = 'R'
                s = e
        return ''.join(res[1:-1])
