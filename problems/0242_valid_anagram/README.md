# 242 Valid Anagram

**LeetCode Link:** [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/)  
**Difficulty:** Easy  
**Tags:** String, Hash Table, Sorting

---

## 題目描述

給定兩個字串 `s` 和 `t`，判斷 `t` 是否是 `s` 的重新排列（Anagram）。  

- Anagram 指兩個字串由相同字母組成，且每個字母出現次數相同。  
- 假設字串只包含小寫字母 a-z。

### 範例

- Input: `s = "anagram"`, `t = "nagaram"` → Output: `true`
- Input: `s = "rat"`, `t = "car"` → Output: `false`

---

## 解法概念

### 方法 1：排序

- 將 `s` 與 `t` 排序，若排序後相同 → 是 Anagram
- **優點**：程式簡單  
- **缺點**：時間複雜度較高 O(n log n)

### 方法 2：Hash Table / Counter

- 使用字母計數：
  1. 遍歷 `s`，對每個字母計數 +1  
  2. 遍歷 `t`，對每個字母計數 -1  
  3. 最後檢查所有字母計數是否為 0
- **優點**：時間 O(n)，空間 O(1)（因為只有 26 個字母）

---

## 時間與空間複雜度

- **排序方法**
  - 時間：O(n log n)  
  - 空間：O(n)（排序需要額外空間）
- **Hash Table / Counter**
  - 時間：O(n)  
  - 空間：O(1)（固定 26 個字母的計數）
