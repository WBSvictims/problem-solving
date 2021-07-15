from collections import defaultdict
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        vals = defaultdict(list)
        for row in range(9):
            for col in range(9):
                n = board[row][col]
                if n != ".":
                    vals[n].append((row, col, (row//3, col//3)))
        
        def validateNum(arr):
            rows, cols, pos = set(), set(), set()
            for r, c, p in arr:
                rows.add(r)
                cols.add(c)
                pos.add(p)
            return len(arr) == len(rows) == len(cols) == len(pos)

        for k in vals.keys():
            if validateNum(vals[k]) == False:
                return False
        return True