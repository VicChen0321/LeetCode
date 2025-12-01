# 2141 Maximum Running Time of N Computers

**LeetCode Link:** [2141. Maximum Running Time of N Computers](https://leetcode.com/problems/maximum-running-time-of-n-computers/)  
**Difficulty:** Medium  
**Tags:** Binary Search, Greedy, Math

---

## 題目描述

給定 `n` 台電腦和一個整數陣列 `batteries`，每個元素表示一個電池的電量（小時數）。  

- 每台電腦可以裝一個電池，電池耗盡後可以換另一個電池。  
- 問最多可以讓所有電腦 **同時運行的最大時間**（小時）。

### 範例

- Input: `n = 2, batteries = [3,3,3]` → Output: `4`  
  解釋：  
  - 首先，將電池 0 裝入第一台電腦，電池 1 裝入第二台電腦。
  - 兩分鐘後，從第二台電腦取出電池 1，換入電池 2。注意，電池 1 還能繼續運作一分鐘。
  - 第三分鐘結束時，電池 0 電量耗盡，需要從第一台電腦取出，換入電池 1。
  - 第四分鐘結束時，電池 1 也電量耗盡，第一台電腦停止運作。
  - 兩台電腦最多可以同時運作 4 分鐘，因此我們取 4。

- Input: `n = 2, batteries = [1,1,1,1]` → Output: `2`  
  解釋：  
  - 可以分配兩顆電池給兩台電腦，運行 2 小時

---

## 解法概念

### 方法：Binary Search + Greedy

- **Binary Search**：
  - 搜尋最大可能運行時間 `T`，範圍 `[1, sum(batteries) / n]`  
- **檢查函式**：
  - 對於每個電池 `b`，計算 `min(b, T)` → 表示這顆電池最多能貢獻 T 小時  
  - 將所有貢獻累加，如果累加值 ≥ `n * T`，表示可以達到 T 小時  
- Binary Search 找到最大的 T 就是答案

---

## 時間與空間複雜度

- **時間複雜度：** O(m · log S)  
  - m = `batteries.length`  
  - S = 總電量除以 n（search range 最大值）  
  - 每次檢查需要 O(m)  
- **空間複雜度：** O(1)  
  - 使用常數額外空間
