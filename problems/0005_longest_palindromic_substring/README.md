# 5 Longest Palindromic Substring

**LeetCode Link:** [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)  
**Difficulty:** Medium  
**Tags:** String, Dynamic Programming, Expand Around Center

---

## 題目描述
給定一個字串 `s`，找出其中 **最長的回文子串**。

### 範例：
- Input: `"babad"` → Output: `"bab"` 或 `"aba"`  
- Input: `"cbbd"` → Output: `"bb"`

Constraints:
- `1 <= s.length <= 1000`
- `s` 僅包含數字與英文字母

---

## 解法概念

### 方法 1：中心擴展法（Expand Around Center）
**核心思路：**
回文一定是從中心向兩邊擴展的，中心有兩種情況：
1. 單一字元為中心（奇數長度回文）
2. 兩個相鄰字元為中心（偶數長度回文）

**步驟**
1. 遍歷字串的每個位置，將其視為回文中心
2. 從中心向兩邊擴展，檢查是否為回文
3. 記錄擴展過程中遇到的最長回文

**時間與空間複雜度**
- **時間：** O(n²)，每個中心最多擴展 O(n)  
- **空間：** O(1)