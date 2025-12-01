# 62 Unique Paths

**LeetCode Link:** [62. Unique Paths](https://leetcode.com/problems/unique-paths/)
**Difficulty:** Medium
**Tags:** Dynamic Programming, Combinatorics, Grid

---

## 題目描述

給定一個 `m x n` 的網格，從左上角 `(0,0)` 移動到右下角 `(m-1,n-1)`，每次只能向 **右** 或 **下** 移動，問共有多少條不同的路徑。

---

### 範例

**Input**

```
m = 3, n = 7
```

**Output**

```
28
```

**Input**

```
m = 3, n = 2
```

**Output**

```
3
```

**Explanation:**
路徑為：

1. 右 → 下 → 下
2. 下 → 下 → 右
3. 下 → 右 → 下

---

## 解法概念

### 方法一：動態規劃（DP）

* 定義狀態：

  * `dp[i][j]` → 到達格子 `(i,j)` 的路徑數
* 狀態轉移：

  ```
  dp[i][j] = dp[i-1][j] + dp[i][j-1]
  ```

  因為只能從上方或左方來
* 初始條件：

  ```
  dp[0][*] = 1
  dp[*][0] = 1
  ```

* Python 寫法：

```python
def uniquePaths(m, n):
    dp = [[1]*n for _ in range(m)]
    for i in range(1, m):
        for j in range(1, n):
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
    return dp[m-1][n-1]
```

---

### 方法二：滾動陣列優化（O(n) 空間）

```python
def uniquePaths(m, n):
    dp = [1] * n
    for i in range(1, m):
        for j in range(1, n):
            dp[j] += dp[j-1]
    return dp[-1]
```

* 原理：每次更新當前 row，只需上一 row 的資訊

---

### 方法三：數學組合（Combinatorics）

* 從 `(0,0)` 到 `(m-1,n-1)` 總共要走 `(m-1)` 次下 + `(n-1)` 次右
* 不同路徑數 = 從 `(m+n-2)` 步中選擇 `(m-1)` 步向下：

```
C(m+n-2, m-1) = (m+n-2)! / ((m-1)! * (n-1)!)
```

* Python 寫法：

```python
import math
def uniquePaths(m, n):
    return math.comb(m+n-2, m-1)
```

---

## 時間與空間複雜度

| 方法      | 時間複雜度       | 空間複雜度  | 備註    |
| ------- | ----------- | ------ | ----- |
| DP 二維陣列 | O(m*n)      | O(m*n) | 初學易理解 |
| DP 一維陣列 | O(m*n)      | O(n)   | 空間優化  |
| 組合公式    | O(min(m,n)) | O(1)   | 直接計算  |

---

## 核心關鍵

* DP 思路：到達每個格子的路徑 = 左 + 上
* 空間優化：只需保存上一行資訊
* 組合公式：將問題轉換為 **選步數組合**
* 適合延伸到障礙物、變化步長等變種問題
