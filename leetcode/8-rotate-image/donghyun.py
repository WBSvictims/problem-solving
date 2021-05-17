class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(n):
            for j in range(i, n - i - 1):
                self.do_rotate(matrix, i, j, i, j, n, matrix[i][j])
        return matrix

    def do_rotate(self, matrix, sy, sx, y, x, n, nval):
        nx = n - 1 - y
        ny = x
        nv = matrix[ny][nx]
        # print(ny, nx, nval)
        if nval is not None:
            matrix[ny][nx] = nval
        if ny == sy and nx == sx:
            return True
        return self.do_rotate(matrix, sy, sx, ny, nx, n, nv)
