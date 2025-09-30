# 3159. Find Occurrences of an Element in an Array

**LeetCode Link:** [3159. Find Occurrences of an Element in an Array](https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/)  
**Difficulty:** Medium  
**Tags:** Array, Hash Table, Simulation

---

## 題目描述

給你一個整數陣列 `nums`、一個整數陣列 `queries`，還有一個整數 `x`。  

對於每個 `queries[i]`，請你尋找 `nums` 中第 `queries[i]` 次出現的 `x` 的索引。  
如果 `nums` 中出現 `x` 的次數小於 `queries[i]`，答案為 `-1`。  

回傳一個整數陣列 `answer`，其中 `answer[i]` 為上述每個查詢的結果。  
（也就是：對每個查詢，回傳第 k 次出現的那個位置，若不存在則 -1）

---

## 範例

**Example 1**  
Input: `nums = [1,3,1,7]`, `queries = [1,3,2,4]`, `x = 1`  
Output: `[0, -1, 2, -1]`  
解釋：  
- 第 1 次出現的 `1` 在索引 `0`  
- 第 3 次出現的 `1` 不存在 → `-1`  
- 第 2 次出現的 `1` 在索引 `2`  
- 第 4 次出現的 `1` 也不存在 → `-1`

**Example 2**  
Input: `nums = [1,2,3]`, `queries = [10]`, `x = 5`  
Output: `[-1]`  
解釋：`x = 5` 在 `nums` 中根本沒出現過 → 所有查詢結果都為 `-1`

---

## 解法概念

### 方法：預處理 + 查詢

1. **預處理 (一次遍歷)**  
   建立一個 list `indices`，存放 `nums` 中所有值為 `x` 的索引（按照發生順序）。  

2. **回應查詢**  
   對於每個查詢 `q = queries[i]`：
   - 如果 `q <= indices.size()` → 回傳 `indices[q - 1]`（第 q 次出現的索引）  
   - 否則 → 回傳 `-1`

這樣每個查詢是 O(1) 的操作，整體時間複雜度 O(n + q)。

---

## 時間與空間複雜度

- **時間複雜度：** O(n + m)，n = `nums.length`，m = `queries.length`  
- **空間複雜度：** O(n)（儲存 x 出現的所有索引）

---

## 關鍵重點

- 利用額外的 list 儲存出現位置後可以快速回應所有查詢。  
- 查詢時要注意 `queries[i]` 是第幾次（所以要用 `q - 1` 做索引）。  
- 若出現次數不足，要回傳 -1。

