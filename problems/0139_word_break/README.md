# 0139. Word Break

**LeetCode Link:** [https://leetcode.com/problems/word-break](https://leetcode.com/problems/word-break)
**Difficulty:** Medium
**Tags:** DP, String, HashSet

---

## 題目描述

給定一個字串 `s` 與一個字典 `wordDict`（字串陣列），判斷 `s` 是否能被「完全切割」成數個字典中的單字組合。

* 切割後的每段都必須是 `wordDict` 中的單字。
* 單字可以重複使用。
* 必須整個字串都能被拆完，不能剩餘任何部分。

### 範例

* **Input:**
  `s = "leetcode"`, `wordDict = ["leet", "code"]`
  **Output:** `true`
  **解釋:** `"leetcode" = "leet" + "code"`

* **Input:**
  `s = "applepenapple"`, `wordDict = ["apple", "pen"]`
  **Output:** `true`
  **解釋:** `"apple" + "pen" + "apple"`

* **Input:**
  `s = "catsandog"`, `wordDict = ["cats","dog","sand","and","cat"]`
  **Output:** `false`
  **解釋:** 沒有方式完全切割

---

## 解法概念

### 方法：Dynamic Programming（DP）

核心想法：
**dp[i] = s[0:i] 是否能被 wordDict 完全切割**

---

### 步驟解析

1. **建立 dp 陣列**

   * `dp` 長度為 `n + 1`
   * `dp[0] = true`（空字串視為可切割）

2. **外圈遍歷字串位置 i（1 ~ n）**

   * 表示我們要判斷 `s[0:i]` 是否可以切割

3. **內圈遍歷 j（0 ~ i）**

   * 若 `dp[j] == true` 且 `s[j:i]` 在字典中
     → `dp[i] = true`

4. **回傳 dp[n]**

   * 表示整個字串是否能被切割

---

### 關鍵 Insight

* **只要前半可切，再來後半也是字典中的字，就能推得整段可切。**
* 使用 **HashSet** 加速字典查詢。
* 典型一維 DP，類似「切割點 DP」。

---

## 時間與空間複雜度

* **時間複雜度:** `O(n^2)`
  兩層迴圈（i, j），字串切片判斷平均 O(1)

* **空間複雜度:** `O(n)`
  DP 陣列大小
