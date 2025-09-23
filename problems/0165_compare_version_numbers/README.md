# 165. Compare Version Numbers

**LeetCode Link:** [165. Compare Version Numbers](https://leetcode.com/problems/compare-version-numbers/)  
**Difficulty:** Medium  
**Tags:** String, Two Pointers

---

## 題目描述
給定兩個版本號字串 `version1` 和 `version2`，比較它們的大小。  
版本號由多個 **revision（修訂號）** 組成，以 `.` 分隔。  
每個修訂號由整數表示，可能有前導零。  

比較規則：
- 逐個修訂號比較，較大的修訂號表示該版本較大。
- 若一方修訂號不足，視為 `0`。

返回：
- `1` 如果 `version1 > version2`
- `-1` 如果 `version1 < version2`
- `0` 如果相等

---

## 範例
- Input: `version1 = "1.01", version2 = "1.001"` → Output: `0`  
- Input: `version1 = "1.0", version2 = "1.0.0"` → Output: `0`  
- Input: `version1 = "0.1", version2 = "1.1"` → Output: `-1`  

---

## 解法概念

### 方法：Split + 逐一比較
1. 使用 `split('.')` 分割版本字串。
2. 將每個部分轉換成整數（自動處理前導零）。
3. 使用兩個指標逐一比較對應的修訂號。
4. 若某一方長度不足，補 `0`。
5. 找到第一個不相等的地方立即回傳結果。

---

## 時間與空間複雜度
- **時間複雜度：** O(n)，其中 `n` 為修訂號總數。  
- **空間複雜度：** O(n)，儲存分割後的陣列。  

---

## 關鍵重點
- 前導零自動處理 → 轉整數即可  
- 長度不足時補零  
- 逐一比較直到不同或結束  