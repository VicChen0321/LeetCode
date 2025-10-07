# 778. Swim in Rising Water

**LeetCode Link:** [778. Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/)  
**Difficulty:** Hard  
**Tags:** Graph, Dijkstra, BFS, Binary Search, Priority Queue

---

## 題目描述

給定一個 `n x n` 的整數矩陣 `grid`，其中 `grid[i][j]` 代表方格的高度。  

你從左上角 `(0,0)` 出發，目標是抵達右下角 `(n-1,n-1)`。  

水位會隨時間上升，當時間 `t` 到達時，水位即為 `t`。  
你可以在水位 `t` 時進入任意高度 ≤ `t` 的方格，並可上下左右移動。  

請找出**最小的時間 t**，使得你可以從起點走到終點。

---

## 範例

**範例 1：**
```text
Input: grid = 
[[0,2],
 [1,3]]
Output: 3
```
  
---

**範例 2：**
```text
Input: grid = 
[[0,1,2,3,4],
 [24,23,22,21,5],
 [12,13,14,15,16],
 [11,17,18,19,20],
 [10,9,8,7,6]]
Output: 16
```


---

## 解法概念

### 方法一：Dijkstra（最小堆 / 優先隊列）

1. 這題可視為在圖上找「路徑中最大高度最小」的問題。  
   → 要最小化走過的最大高度。
2. 使用 **最小堆 (min-heap)** 模擬水位上升：
   - 從 (0,0) 出發，將可達方格依照高度放入堆中。
   - 每次取出當前最低的格子。
   - 更新目前經過的最大水位。
   - 抵達右下角時即為答案。
3. 本質是 **Dijkstra 最短路徑** 的變形，距離改為「最大高度」。

### 方法二：Binary Search + BFS
1. 時間 `t` 範圍：`[max(grid[0][0], grid[n-1][n-1]), n^2 - 1]`
2. 二分搜尋水位 `mid：`
   - 若在 `t = mid` 時能到達 `(n-1,n-1)` → 嘗試更小 `t`
   - 否則提升 `t`
3. 透過 BFS 

---

## 時間與空間複雜度
| 方法                | 時間複雜度   | 空間複雜度 | 備註             |
| ------------------- | ------------ | ---------- | ---------------- |
| Dijkstra            | O(n² log n)  | O(n²)      | 最常見且高效     |
| Binary Search + BFS | O(n² log n²) | O(n²)      | 結構簡單，易理解 |



        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int ans = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], x = cur[1], y = cur[2];
            ans = Math.max(ans, t);

            if (x == n - 1 && y == n - 1) return ans;
            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    pq.offer(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }
        return ans;