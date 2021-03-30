from queue import PriorityQueue


class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        size = len(grid)
        if grid[0][0] != 0 or grid[size - 1][size - 1] != 0:
            return -1
        # print(size)
        # BFS
        # direction. top, clockwise
        dir_y = [-1, -1, 0, 1, 1, 1, 0, -1]
        dir_x = [0, 1, 1, 1, 0, -1, -1, -1]
        q = PriorityQueue()
        q.put((1, 0, 0))
        while not q.empty():
            p, y, x = q.get()
            # print(y, x)
            if y == x == size - 1:
                return p
            for dy, dx in zip(dir_y, dir_x):
                # print(dy, dx)
                nx, ny = x + dx, y + dy
                if self.in_range(nx, ny, size, size) and grid[ny][nx] == 0:
                    q.put((p + 1, ny, nx))
                    grid[ny][nx] = 1
        return -1

    def in_range(self, x, y, lx, ly):
        return 0 <= x < lx and 0 <= y < ly
