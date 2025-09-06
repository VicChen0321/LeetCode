# 3495 Minimum Operations to Make Array Elements Zero

**LeetCode Link:** [3495. Minimum Operations to Make Array Elements Zero](https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/)  
**Difficulty:** Hard  
**Tags:** Greedy, Math, Prefix Sum

---

## 題目描述
給定多組範圍查詢 `queries`，每個查詢是 `[l, r]`，代表一個陣列 `nums = [l, l+1, ..., r]`。  
在一次操作中，你可以從 `nums` 中選出任意兩個元素 `a` 和 `b`，並將它們分別替換為 `floor(a / 4)` 和 `floor(b / 4)`。  
重複進行操作，直到所有元素都變成 `0` 為止。  

請回傳所有查詢所需的最少操作次數總和。

---

## 解法概念

### 核心思路
1. 考慮一個數字 `n`，要變成 `0` 需要多少次 `floor(x / 4)` 操作？  
   - `1 ~ 3` 需要 1 次  
   - `4 ~ 15` 需要 2 次  
   - `16 ~ 63` 需要 3 次  
   - 依此類推，每個區間長度是 `4^k ~ 4^(k+1)-1`  

2. 定義一個輔助函式 `getOps(n)`：計算從 `1` 到 `n` 的所有數字總共需要多少次操作。  

3. 查詢 `[l, r]` 的答案就是： `(getOps(r) - getOps(l-1) + 1) // 2`
- 減去前綴`getOps(l - 1)` 去得到 `[l, r]` 的操作總數
- 除以 2，因為一次操作可以同時處理兩個元素
> 後面 +1 的目的是為了向上取整的技巧，等價於 ceil((getOps(r) - getOps(l - 1))) // 2  
  
---
## 複雜度分析
- 時間複雜度： O(q · log n)，q = 查詢數
- 空間複雜度： O(1)
  
---

## 核心關鍵
- 每個數字的操作次數取決於它落在哪個 `4^k` 區間
- 使用前綴計算避免逐個模擬
- 除以 2 因為一次操作處理兩個元素