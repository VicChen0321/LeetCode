# 0383 - Ransom Note

**LeetCode Link:** [https://leetcode.com/problems/ransom-note/](https://leetcode.com/problems/ransom-note/)
**Difficulty:** Easy
**Tags:** Hash Table, String, Counting

---

## 題目描述

給你兩個字串：

* `ransomNote`：勒索信內容
* `magazine`：雜誌內容

請判斷是否可以**從 `magazine` 中剪下字母**來組成 `ransomNote`。

* 每個字母在 `magazine` 中**只能使用一次**
* 只能使用英文字母小寫 (`a`–`z`)
* 字母數量不足即回傳 `false`

### 範例

* Input: `ransomNote = "a"`, `magazine = "b"` → Output: `false`
  `magazine` 沒有字母 `a`

* Input: `ransomNote = "aa"`, `magazine = "ab"` → Output: `false`
  `a` 的數量不足

* Input: `ransomNote = "aa"`, `magazine = "aab"` → Output: `true`
  `magazine` 中有足夠的 `a`

---

## 解法概念

這題本質是 **字元計數是否足夠**，不需要任何複雜演算法。

### 方法：Hash / Counting Array

#### 核心想法

* 先統計 `magazine` 中每個字母出現次數
* 再逐字消耗 `ransomNote` 所需的字母
* 只要某個字母用到負數，代表不夠 → `false`

#### 演算法步驟

1. 建立長度為 26 的整數陣列 `count`
2. 掃描 `magazine`，對應字母計數 `+1`
3. 掃描 `ransomNote`，對應字母計數 `-1`
4. 若任何時候計數 < 0，立即回傳 `false`
5. 全部掃完仍合法 → `true`

#### 關鍵 insight

* 題目已限制只會有小寫字母
  → **不需要 HashMap，用 array 更快更簡單**
* 提早失敗（early return）可省時間

> 小提示：
> 若題目沒有限制字元範圍，才需要 `HashMap<Character, Integer>`。

---

## 時間與空間複雜度

* **時間複雜度**：O(n + m)
  `n` = `magazine` 長度，`m` = `ransomNote` 長度
* **空間複雜度**：O(1)（固定 26 個字母）
