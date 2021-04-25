class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        d = list(dominoes)
        
        i = 0
        while i < len(d) and i > -1:
            if d[i] == "R":
                idxL, hasL = -1, False
                # if there's L and nothing exists between R and L
                for x in range(i+1, len(d)):
                    if d[x] == "R":
                        break
                    if d[x] == "L":
                        ixL, hasL = x, True
                        break
                if hasL:
                    # R -> L
                    interval = x-i-1
                    mid = (i+x)/2
                    for a in range(i, x):
                        if float(a) == mid:
                            continue
                        elif a < mid:
                            d[a] = "R"
                        else:
                            d[a] = "L"
                    i = x+1
                    # print(i, "RIGHT", d)
                else:
                    p = i+1
                    while True:
                        if p < len(d) and d[p] == ".":
                            d[p]= "R"
                            p = p+1
                        else:
                            i = i+1
                            break
            elif d[i] == "L":
                p = i-1
                while True:
                    if p >= 0 and d[p] == ".":
                        d[p] = "L"
                        p = p-1
                    else:
                        i = i+1
                        # print(i, "LEFT", d)
                        break
            else:
                i = i+1
        # print(d)
        return "".join(d).replace("n", "")