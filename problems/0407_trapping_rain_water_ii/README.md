# 407. Trapping Rain Water II

**LeetCode Link:**[407. Trapping Rain Water II](https://leetcode.com/problems/trapping-rain-water-ii/)  
**Difficulty:** Hard  
**Tags:** Matrix, BFS, Heap, Priority Queue, Graph

---

## 題目描述

給你一個 `m × n` 的高度地圖 `heightMap`（每格為非負高度）。  
雨後水會在低窪處積聚，但水只能被四個方向較高或等高的欄杆圍住，否則會流出邊界。  
請計算這個地圖在雨後總共能積多少水。

邊界格子不能積水（因為水會流出）。

---

## 範例

- Input: `heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]`
- Output: `4`
  
- Input: `heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]`
- Output: `10`

---

## 解法概念

### 方法：從邊界起洪水／最小高度優先 (Min-Heap + BFS)

直覺來說，水會從邊界流入低地，最低的邊界限制水位高度。  
我們可以：

1. 將所有邊界格子加入最小堆（Priority Queue），並標記為已訪問。
2. 每次從堆中彈出高度最低的格子 `(h, r, c)`。
3. 探索它的四個鄰居 `(nr, nc)`，若未訪問：
 - 若鄰居高度 `< h`，表示可在該鄰居積水 `h - heightMap[nr][nc]`。
 - 更新鄰居的新“水高度”為 `max(h, heightMap[nr][nc])`，並加入堆中。
 - 標記鄰居為已訪問。
4. 最終累加所有積水量。

這樣保證：我們永遠先處理最低的界牆，水位由最低限制推進，才能正確模擬積水過程。

---

## 時間與空間複雜度

- **時間複雜度：** O(m × n × log(m × n))，因為每個格子會被推入堆一次，堆操作帶 log 因素。
- **空間複雜度：** O(m × n)，需要額外的 visited 標記 + 堆

class Solution {
  private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

  public int trapRainWater(int[][] heightMap) {
      int m = heightMap.length, n = heightMap[0].length;
      boolean[][] visited = new boolean[m][n];
      PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[0] - b[0] );
      // pq stored as [height, r, c]

      // 加入邊界格子
      for (int i = 0; i < m; i++) {
          visited[i][0] = true;
          visited[i][n-1] = true;
          pq.offer(new int[]{heightMap[i][0], i, 0});
          pq.offer(new int[]{heightMap[i][n-1], i, n-1});
      }
      for (int j = 1; j < n-1; j++) {
          visited[0][j] = true;
          visited[m-1][j] = true;
          pq.offer(new int[]{heightMap[0][j], 0, j});
          pq.offer(new int[]{heightMap[m-1][j], m-1, j});
      }

      int result = 0;
      while (!pq.isEmpty()) {
          int[] cur = pq.poll();
          int h = cur[0], r = cur[1], c = cur[2];
          for (int[] d : DIRS) {
              int nr = r + d[0], nc = c + d[1];
              if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
              if (visited[nr][nc]) continue;
              visited[nr][nc] = true;
              if (heightMap[nr][nc] < h) {
                  result += h - heightMap[nr][nc];
              }
              pq.offer(new int[]{ Math.max(h, heightMap[nr][nc]), nr, nc });
          }
      }

      return result;
  }
}