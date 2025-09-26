# 217. Contains Duplicate

**LeetCode Link:** [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)  
**Difficulty:** Easy  
**Tags:** Array, Hash Table, Sorting

---

## 題目描述
給定一個整數陣列 `nums`，請判斷是否存在至少一個數字在陣列中出現超過一次。  

若存在，回傳 `true`；否則回傳 `false`。

---

## 範例
- Input: `nums = [1,2,3,1]`  
  Output: `true`

- Input: `nums = [1,2,3,4]`  
  Output: `false`

- Input: `nums = [1,1,1,3,3,4,3,2,4,2]`  
  Output: `true`

---

## 解法概念

### 方法一：HashSet  
1. 建立一個集合 `seen`。  
2. 遍歷每個數字：
   - 如果該數字已在 `seen` 中出現，立即回傳 `true`。
   - 否則加入 `seen`。  
3. 遍歷完成仍無重複，回傳 `false`。  

### 方法二：排序  
1. 對陣列進行排序。  
2. 檢查相鄰的元素是否相同。  
3. 若有相同，回傳 `true`，否則 `false`。

---

## 時間與空間複雜度
- **方法一（HashSet）：**  
  - 時間：O(n)  
  - 空間：O(n)  

- **方法二（排序）：**  
  - 時間：O(n log n)  
  - 空間：O(1)（就地排序）

---

## 關鍵重點
- HashSet 是最直覺、最快速的解法。  
- 排序解法適合在空間有限制時使用。  