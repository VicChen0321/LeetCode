下面是 **LeetCode 0417 – Pacific Atlantic Water Flow** 的完整筆記，依你提供的格式撰寫：

---

# 0417 Pacific Atlantic Water Flow

**LeetCode Link:** [https://leetcode.com/problems/pacific-atlantic-water-flow/](https://leetcode.com/problems/pacific-atlantic-water-flow/)
**Difficulty:** Medium
**Tags:** Matrix, DFS, BFS, Graph, Simulation

---

## 題目描述

給定一個 `m x n` 的矩陣 `heights`，每個格子代表地形高度。水可以從一個格子流向 **相鄰的上下左右** 低於或等於自己高度的格子。

* 左邊和上邊界相鄰太平洋 (Pacific)
* 右邊和下邊界相鄰大西洋 (Atlantic)
* 請找出所有 **水可以同時流到太平洋與大西洋** 的格子。

### 限制與注意事項

* 水只能流向高度 ≤ 當前格子的鄰居
* 回傳所有符合條件的格子坐標列表
* `1 <= m, n <= 200`
* `0 <= heights[i][j] <= 10^5`

### 範例

* Input:

  ```
  heights = [
    [1,2,2,3,5],
    [3,2,3,4,4],
    [2,4,5,3,1],
    [6,7,1,4,5],
    [5,1,1,2,4]
  ]
  ```

  Output:

  ```
  [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
  ```

  解釋：這些格子水可以流向太平洋和大西洋。

* Input: `heights = [[2,1],[1,2]]` → Output: `[[0,0],[0,1],[1,0],[1,1]]`

---

## 解法概念

### 方法：DFS / BFS 反向搜尋

核心思路：

1. **逆向思考**：不是從每個格子出發看水能流去哪，而是 **從太平洋與大西洋邊界出發，找哪些格子能流到它們**。
2. 對每個邊界使用 DFS 或 BFS，沿著 **高度非下降方向** 搜尋可到達的格子。
3. 分別得到兩個矩陣/集合：

   * `pacific_reachable`
   * `atlantic_reachable`
4. 最後取交集 → 同時能到兩個海洋的格子。

---

### 步驟示意

1. 初始化兩個 `m x n` 的 boolean 矩陣 `pacific` 與 `atlantic`
2. DFS/BFS 從 **太平洋邊界**：

   * 上邊界所有列 + 左邊界所有行
3. DFS/BFS 從 **大西洋邊界**：

   * 下邊界所有列 + 右邊界所有行
4. DFS/BFS 過程：

   * 只走 **下一格高度 >= 當前格高度** 的路徑
   * 標記可到達的格子
5. 遍歷整個矩陣，取兩個矩陣交集 → 結果

> 直覺：從海洋反推可到達的格子，比從每個格子單獨出發效率高很多。

---

## 時間與空間複雜度

* **時間複雜度**：O(m * n)

  * 每個格子最多被 DFS/BFS 走一次，兩次（太平洋 + 大西洋）
* **空間複雜度**：O(m * n)

  * 需要兩個矩陣或集合紀錄可達格子，DFS recursion 也最多 O(m*n) stack

## 常見錯誤陷阱

* DFS 走錯方向：只能走 **高度 >= 當前格**
* 沒有分別紀錄太平洋與大西洋 reachable → 無法求交集
* 遞迴過深 Python 可能要設定 recursion limit
* BFS 實現時 queue 處理不當會漏格子

---

如果你想，我可以幫你再寫 **BFS 版本** 並附 **優化版程式碼**，對比 DFS。
