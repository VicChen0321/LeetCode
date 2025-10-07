class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        visited = [[False] * n for _ in range(n)]
        pq = [(grid[0][0], 0, 0)]
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        max_t = 0
        while pq:
            t, x, y = heapq.heappop(pq)
            if visited[x][y]:
                continue
            visited[x][y] = True
            max_t = max(max_t, t)

            if x == n - 1 and y == n - 1:
                return max_t
            for dx, dy in dirs:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                    heapq.heappush(pq, (grid[nx][ny], nx, ny))
        return -1