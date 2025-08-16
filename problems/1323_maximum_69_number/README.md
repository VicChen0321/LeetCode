# 1323 Maximum 69 Number

**LeetCode Link:** [1323. Maximum 69 Number](https://leetcode.com/problems/maximum-69-number/)  
**Difficulty:** Easy  
**Tags:** Math, Greedy

---

## 題目描述
給定一個僅由數字 `6` 和 `9` 組成的正整數，最多可以將其中一個 `6` 改成 `9`，求可以得到的最大數字。

- 範例：
  - Input: `9669` → Output: `9969`
  - Input: `9996` → Output: `9999`
  - Input: `9999` → Output: `9999`

Constraints:
- 1 ≤ num ≤ 10⁴
- num 僅包含數字 6 和 9

---

## 解法概念

- 最多只能變化一次，因此要得到最大的數字，肯定是把 6 變成 9 得到的數字最大，且盡量去變高位上的數字。

### 方法 1：字串替換
- 將整數轉成字串，找到從左第一個 `'6'` 替換成 `'9'` 即可。
- 因為只允許替換一次，直接結束。
- 時間複雜度：O(d) （d 為數字位數）
- 空間複雜度：O(d) （字串額外儲存）