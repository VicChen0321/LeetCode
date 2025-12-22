# 0070 - Climbing Stairs

**LeetCode Link:** [https://leetcode.com/problems/climbing-stairs/](https://leetcode.com/problems/climbing-stairs/)
**Difficulty:** Easy
**Tags:** Dynamic Programming, Math, Fibonacci

---

## 題目描述

你正在爬一個樓梯，樓梯總共有 `n` 階。
每次你可以爬 **1 階或 2 階**，請問**總共有幾種不同的方法**可以爬到頂樓？

* 每一步只能走 1 或 2 階
* 順序不同視為不同方法
* `n` 為正整數

### 範例

* Input: `n = 2` → Output: `2`
  解釋：

  * 1 + 1
  * 2

* Input: `n = 3` → Output: `3`
  解釋：

  * 1 + 1 + 1
  * 1 + 2
  * 2 + 1

---

## 解法概念

這題是 **Dynamic Programming 入門必考題**，本質上就是 **Fibonacci 數列**。

### 方法：Dynamic Programming（Bottom-up）

#### 核心想法

要到第 `n` 階：

* 最後一步如果走 1 階 → 從 `n-1` 上來
* 最後一步如果走 2 階 → 從 `n-2` 上來

所以：

```
dp[n] = dp[n-1] + dp[n-2]
```

#### 演算法步驟

1. 定義 `dp[i]`：走到第 `i` 階的方法數
2. 初始化：

   * `dp[1] = 1`
   * `dp[2] = 2`
3. 由小到大推：

   * `dp[i] = dp[i-1] + dp[i-2]`
4. 回傳 `dp[n]`

#### 關鍵 insight

* 這題不是排列組合，而是「最後一步從哪來」
* 狀態轉移一旦寫出來，就直接是 Fibonacci
* **只依賴前兩項 → 空間可壓縮**

> 小提示：
> 如果你看到「每一步有固定幾種選擇、問總方法數」，十之八九是 DP。

---

## 時間與空間複雜度

* **時間複雜度**：O(n)
* **空間複雜度**：

  * O(n)：使用 dp array
  * O(1)：只保留前兩個狀態（最佳解）
