class Solution {
    private final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // pq storead as [height, r, c]

        // add boundary cells
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n-1] = true;
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][n-1], i, n-1});
        }
        for (int j = 1; j < n - 1; j++) {
            visited[0][j] = true;
            visited[m - 1][j] = true;
            pq.offer(new int[]{heightMap[0][j], 0, j});
            pq.offer(new int[]{heightMap[m-1][j], m-1, j});
        }

        int res = 0; 
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int h = cur[0], r = cur[1], c = cur[2];
            for (int[] d: DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >=m || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                if (heightMap[nr][nc] < h) {
                    res += h - heightMap[nr][nc];
                }
                pq.offer(new int[]{Math.max(h, heightMap[nr][nc]), nr, nc});
            }
        }
        return res;
        
    }
}