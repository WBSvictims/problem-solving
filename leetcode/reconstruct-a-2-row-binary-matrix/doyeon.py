class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        if not self.isValid(upper, lower, colsum):
            return []
        colCount = len(colsum)
        firstRow = [0]*colCount
        
        for i in range(colCount):
            if colsum[i] == 2:
                upper -= 1
                colsum[i] -= 1
                firstRow[i] += 1
        
        for i in range(colCount):
            if firstRow[i] == 0 and colsum[i] == 1 and upper > 0:
                upper -= 1
                colsum[i] -= 1
                firstRow[i] = 1
            else:
                continue
        
        return [firstRow, colsum]
        
        
    def isValid(self, upper, lower, colsum):
        if upper+lower != sum(colsum):
            return False
        elif min([upper, lower]) < colsum.count(2):
            return False
        return True