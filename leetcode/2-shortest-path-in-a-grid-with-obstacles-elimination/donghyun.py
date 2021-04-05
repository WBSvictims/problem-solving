from queue import PriorityQueue

class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        n = len(grid)
        m = len(grid[0])
        # int[n][n][k]
        cache = [[[0] * (k+1) for x in range(m)] for x in range(n)]
        # print(cache)
        # BFS, cache k
        dir_y = [-1, 0, 1, 0]
        dir_x = [0, 1, 0, -1]
        que = PriorityQueue()
        # pathSize, path-k, dy, dx
        que.put((0, 0, 0, 0))
        while not que.empty():
            p, pk, y, x = que.get()
            # print(p, pk, y, x)
            if y == n - 1 and x == m - 1:
                return p
            if cache[y][x][pk]:
                continue
            cache[y][x][pk] = 1
            for dy, dx in zip(dir_y, dir_x):
                nx, ny = x + dx, y + dy
                if self.in_range(nx, ny, m, n) and not cache[ny][nx][pk] == 1:
                    if grid[ny][nx] == 0:
                        que.put((p+1, pk, ny, nx))
                    elif pk < k:
                        que.put((p+1, pk + 1, ny, nx))
        return -1
                
    def in_range(self, x, y, lx, ly):
        return 0 <= x < lx and 0 <= y < ly
