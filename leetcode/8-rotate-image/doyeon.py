class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        l = len(matrix)
        save = {}
        for x in range(l):
            for y in range(l-1, -1, -1):
                yy = l-1-y
                save[(x, yy)] = matrix[x][yy]
                matrix[x][yy] = save.get((y, x), matrix[y][x])
        return matrix