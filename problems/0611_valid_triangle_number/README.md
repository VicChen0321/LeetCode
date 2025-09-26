# 611. Valid Triangle Number

**LeetCode Link:** [611. Valid Triangle Number](https://leetcode.com/problems/valid-triangle-number/)  
**Difficulty:** Medium  
**Tags:** Array, Two Pointers, Binary Search, Sorting

---

## 題目描述
給定一個整數陣列 `nums`，請你計算能組成「三角形」的三元組 `(nums[i], nums[j], nums[k])` 的數量。

**條件：**  
三個邊長能組成三角形，需滿足：`a + b > c`

其中 `a ≤ b ≤ c`。

---

## 範例
- Input: `nums = [2,2,3,4]`  
  Output: `3`  
  解釋：可組成的三角形為 `(2,3,4)`, `(2,3,4)`, `(2,2,3)`。

- Input: `nums = [4,2,3,4]`  
  Output: `4`

---

## 解法概念

### 方法：排序 + 雙指針
1. 先對陣列 `nums` 升序排序。  
2. 固定最大邊 `c = nums[k]`。  
3. 設兩個指針：
   - `i = 0`
   - `j = k - 1`
4. 當 `nums[i] + nums[j] > nums[k]`：
   - 說明 `[i, j-1]` 的所有元素與 `nums[j]` 都能形成合法三角形  
   - 將計數加上 `(j - i)`  
   - 然後 `j--`  
5. 否則，若不成立，`i++`。  
6. 最後回傳計數。

---

## 時間與空間複雜度
- **時間複雜度：** O(n²)，排序 O(n log n) + 雙層迴圈 O(n²)  
- **空間複雜度：** O(1)

---

## 關鍵重點
- 核心條件：**兩短邊之和大於最長邊**  
- 排序能保證 `nums[k]` 為當前最大邊  
- 使用 **雙指針**，一次處理多個組合，避免 O(n³)