# 733. Flood Fill

**LeetCode Link:** [733. Flood Fill](https://leetcode.com/problems/flood-fill/)

**Difficulty:** Easy

**Tags:** Array, Depth-First Search (DFS), Breadth-First Search (BFS), Matrix

---

## 題目描述

給定一個代表圖像的二維陣列 `image`，其中 `image[i][j]` 表示該像素的顏色值。另外給定起始座標 `(sr, sc)` 以及一個新顏色 `color`。

你需要從起始座標開始進行「油漆桶填充」：

* 將起始像素的顏色換成新顏色。
* 檢查起始像素 **上下左右** 相鄰的像素，如果它們的顏色與起始像素**原本的顏色**相同，則也將其變更為新顏色。
* 重複此過程，直到所有符合條件的相連像素都被染色。

### 範例

* **Input:** image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
* **Output:** [[2,2,2],[2,2,0],[2,0,1]]
* **解釋:** 從 (1, 1) 開始，其原顏色為 1。所有與它相連且顏色為 1 的像素都被染成 2。注意右下角的 1 因為沒有與被染色的路徑相連，所以保持不變。

---

## 解法概念

### 方法：深度優先搜尋（DFS）

這是一道經典的圖形遍歷題目，最常見的解法是使用遞迴的 DFS。

1. **紀錄目標色**：先記住起始點的原始顏色（`oldColor = image[sr][sc]`）。
2. **處理邊界情況**：如果 `oldColor` 已經等於 `color`，代表不需要染色，直接回傳 `image` 防止無限遞迴。
3. **遞迴染色**：

* 檢查當前座標是否越界。
* 檢查當前像素顏色是否為 `oldColor`。
* 若符合條件，將顏色改為 `color`。
* 對上下左右四個方向遞迴呼叫染色函數。

> **關鍵 Insight**：必須在開始染色前判斷 `oldColor == color`。如果不做這個判斷，當新舊顏色相同時，程式會不斷在相鄰的格點間重複染色，導致 Stack Overflow。

---

## 時間與空間複雜度

* **時間複雜度**：
* 為影像中的像素總數。在最壞情況下（所有像素都需要染色），我們需要訪問每個像素一次。

* **空間複雜度**：
* 主要是遞迴呼叫產生的 Stack 空間。在最壞情況下，遞迴深度可能達到 。

---

## 程式碼（Python / Java）

### Python (DFS)

```python
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        rows, cols = len(image), len(image[0])
        old_color = image[sr][sc]
        
        # 如果新舊顏色一樣，直接回傳避免無限遞迴
        if old_color == color:
            return image
        
        def dfs(r, c):
            # 越界判斷或顏色不符則跳過
            if r < 0 or r >= rows or c < 0 or c >= cols or image[r][c] != old_color:
                return
            
            # 染色
            image[r][c] = color
            
            # 四個方向擴散
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
            
        dfs(sr, sc)
        return image

```

### Java (DFS)

```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor != color) {
            dfs(image, sr, sc, oldColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor) {
            return;
        }
        image[r][c] = newColor;
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }
}

```

---

## 常見錯誤陷阱

1. **無限遞迴**：最常見的錯誤是沒有判斷 `oldColor == color` 的情況。
2. **座標混淆**：在二維陣列中，`image[r][c]` 常用 `r` (row) 代表縱軸，`c` (col) 代表橫軸，處理方向時需謹慎確認 `r` 與 `c` 的增減。
