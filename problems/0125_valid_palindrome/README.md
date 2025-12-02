# 125 Valid Palindrome

**LeetCode Link:** [125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)  
**Difficulty:** Easy  
**Tags:** Two Pointers, String

---

## 題目描述

給定一個字串 `s`，判斷它是否為迴文（Palindrome）。  

- 忽略大小寫、非字母數字字符。  
- Palindrome 指正反讀一樣的字串。

### 範例

- Input: `s = "A man, a plan, a canal: Panama"` → Output: `true`  
- Input: `s = "race a car"` → Output: `false`

---

## 解法概念

### 方法：Two Pointers

1. 設定左右兩個指標 `left = 0`, `right = len(s) - 1`
2. 當 `left < right`：
   - 如果 `s[left]` 不是字母或數字 → `left++`  
   - 如果 `s[right]` 不是字母或數字 → `right--`  
   - 否則比較 `lower(s[left])` 與 `lower(s[right])`：
     - 不同 → 不是迴文  
     - 相同 → `left++`, `right--`
3. 全部檢查完成 → 是迴文

> 技巧：可以使用 `Character.isLetterOrDigit()` 或 Python 的 `str.isalnum()` 來過濾非字母數字。

---

## 時間與空間複雜度

- **時間複雜度：** O(n)  
  - n = 字串長度  
  - 每個字元最多被訪問一次  
- **空間複雜度：** O(1)  
  - 使用指標，不額外存字串（如果使用 clean-up 版本就需要 O(n) 空間）
