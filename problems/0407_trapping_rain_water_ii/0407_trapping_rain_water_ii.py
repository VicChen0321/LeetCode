class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        m = len(heightMap)
        n = len(heightMap[0])
        visited = [[False] * n for _ in range(m)]
        pq = [] # sotred as [height, r, c]

        # Add boundary cells
        for i in range(m):
            visited[i][0] = True
            visited[i][n-1] = True
            heapq.heappush(pq, (heightMap[i][0], i, 0))
            heapq.heappush(pq, (heightMap[i][n-1], i, n-1))
        for j in range(1, n-1):
            visited[0][j] = True
            visited[m-1][j] = True
            heapq.heappush(pq, (heightMap[0][j], 0, j))
            heapq.heappush(pq, (heightMap[m-1][j], m-1, j))
        res = 0
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        while pq:
            h, r, c = heapq.heappop(pq)
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if nr < 0 or nr >= m or nc < 0 or nc >= n or visited[nr][nc]:
                    continue
                visited[nr][nc] = True
                nh = heightMap[nr][nc]
                if nh < h:
                    res += h - nh
                heapq.heappush(pq, (max(h, nh), nr, nc))
        return res
        