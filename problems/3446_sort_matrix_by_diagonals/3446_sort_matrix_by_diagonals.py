import heapq

class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        # top-right triangle (min-heap, ascending)
        for c in range(1, n):
            pq = []
            cur_c, cur_r = c, 0
            while cur_c < n and cur_r < n:
                heapq.heappush(pq, grid[cur_r][cur_c])
                cur_c += 1
                cur_r += 1
            cur_c, cur_r = c, 0
            while cur_c < n and cur_r < n:
                grid[cur_r][cur_c] = heapq.heappop(pq)
                cur_c += 1
                cur_r += 1

        # bottom-left triangle (max-heap, descending)
        for r in range(n):
            pq = []
            cur_c, cur_r = 0, r
            while cur_c < n and cur_r < n:
                heapq.heappush(pq, -grid[cur_r][cur_c])  # push negative
                cur_c += 1
                cur_r += 1
            cur_c, cur_r = 0, r
            while cur_c < n and cur_r < n:
                grid[cur_r][cur_c] = -heapq.heappop(pq)  # pop and flip sign back
                cur_c += 1
                cur_r += 1
                
        return grid