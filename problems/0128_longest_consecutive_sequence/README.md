# 128 Longest Consecutive Sequence

**LeetCode Link:** [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)  
**Difficulty:** Medium  
**Tags:** Array, Hash Table, Union Find, Set

---

## 題目描述

給定一個整數陣列 `nums`，找到陣列中 **最長的連續整數序列**（consecutive sequence）的長度。  

- 要求時間複雜度 O(n)。  
- 連續序列指數字之間連續，例如 `[100, 4, 200, 1, 3, 2]` → 連續序列 `[1,2,3,4]` → 長度 4。

### 範例

- Input: `nums = [100, 4, 200, 1, 3, 2]` → Output: `4`  
  解釋：最長序列 `[1,2,3,4]`

- Input: `nums = [0,3,7,2,5,8,4,6,0,1]` → Output: `9`  
  解釋：最長序列 `[0,1,2,3,4,5,6,7,8]`

---

## 解法概念

### 方法 1：HashSet

- 將所有數字放入 Set，O(1) 查詢  
- 遍歷每個數字 `num`：
  1. 若 `num - 1` 不在 Set 中 → `num` 是序列開頭  
  2. 從 `num` 開始往後找連續數字，計算序列長度  
  3. 更新最大長度 `maxLen`
- **關鍵點**：只從序列開頭開始找，避免重複計算 → O(n)

---

### 方法 2：Union Find（Optional）

- 將相鄰數字 union，最後找最大連續序列長度  
- 比較 HashSet 方法稍慢，實務上 HashSet 足夠

---

## 時間與空間複雜度

- **時間複雜度：** O(n)  
  - 每個元素最多被訪問兩次（一次檢查是否開頭，一次計算序列長度）  
- **空間複雜度：** O(n)  
  - Set 儲存所有元素
