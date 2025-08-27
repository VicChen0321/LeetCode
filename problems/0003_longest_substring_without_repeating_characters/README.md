# 3 Longest Substring Without Repeating Characters

**LeetCode Link:** [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)  
**Difficulty:** Medium  
**Tags:** Hash Table, Two Pointers, Sliding Window, String

---

## 題目描述
給定一個字串 s，找出 **不含重複字元的最長子字串的長度**。

### 範例：
- Input: `"abcabcbb"` → Output: `3`  
  Explanation: `"abc"` 是最長子字串。
- Input: `"bbbbb"` → Output: `1`  
  Explanation: `"b"` 是最長子字串。
- Input: `"pwwkew"` → Output: `3`  
  Explanation: `"wke"` 是最長子字串。

Constraints:
- 0 <= s.length <= 5 * 10^4
- s 由英文字母、數字、符號組成

---

## 解法概念

### 方法 1：Sliding Window + Hash Map
1. 使用兩個指標 `left` 和 `right` 形成滑動窗口，遍歷字串。
2. 用字典 `last_seen` 記錄每個字元最後出現的位置。
3. 當遇到重複字元且位於窗口內時，將左指標移到重複字元的下一個位置。
4. 每次更新窗口大小，保持最大長度。

**注意事項：**
- 滑動窗口法效率高，時間複雜度 O(n)
- 空間複雜度 O(min(n, charset_size))
- 要注意字元索引更新，避免錯過最長子字串

---

## 複雜度分析
- 時間複雜度：O(n)  
- 空間複雜度：O(min(n, charset_size))，取決於字元種類
