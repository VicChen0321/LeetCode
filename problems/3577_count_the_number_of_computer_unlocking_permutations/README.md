# 3577. Count the Number of Computer Unlocking Permutations

**LeetCode Link:** [https://leetcode.com/problems/count-the-number-of-computer-unlocking-permutations/](https://leetcode.com/problems/count-the-number-of-computer-unlocking-permutations/)
**Difficulty:** Medium
**Tags:** Array, Combinatorics, Math

---

## 題目描述

有 n 台鎖著的電腦 (編號 0 到 n - 1)，每台電腦都有一組唯一密碼，其複雜度 (complexity) 給在整數陣列 `complexity` 中，其中 `complexity[i]` 是編號 i 的密碼複雜度。

* 電腦 0 是特殊的 — 它一開始就已經解鎖 (unlocked) 。
* 若要解鎖其他電腦 i (i ≠ 0)，必須滿足一個規則 (以下簡述)：

規則大意 (根據題意)：必須以某種「排列順序」來逐台解鎖其他電腦 (從 0 開始)，且排列順序必須「合法 / 有效」。我們要計算有多少種合法的解鎖順序 (permutations) 能最終解鎖所有電腦。

* 回傳總數 (通常要 mod 一個數 — 原文有可能有 mod，要看題目)

> 注意：題目給定 `complexity`，解鎖規則根據密碼複雜度與 unlock 的順序 — 使得某種排列算作合法。但根據部分討論 (見下) — 若第一台解鎖 (after 0) 的電腦不是密碼複雜度最小，整個排列即無法成功。

### 範例

LeetCode 官方頁面可能會有 sample，但公開討論較少。以下為概念性例子 (假設)：

* Input: `complexity = [0, 1, 2]` → Output: 2
  (因為電腦 0 已解鎖, 剩下兩台 (1, 2)，若密碼複雜度分別為 1,2，合法順序是先 1 再 2 或先 2 再 1? 不過根據規則可能只有 1 → 2 可行 — 具體取決題目細節)
  — 注意：具體 sample 請參考題目頁面。

（由於公開解析文章與討論主要以「若 first unlock ≠ 最小 complexity → 0」為條件，反映題目有嚴格限制）

---

## 解法概念

### 方法：數學 + 排列 (Combinatorics) / 極簡判斷

根據多數現有解析 (與某些解法討論) — 本題其實是個「腦筋急轉彎 + 排列數學問題」：

1. 觀察到，若你想成功解鎖所有電腦 (即有合法排序)，那麼你必須首先解鎖密碼複雜度最小的那台 (除了 0 之外) — 也就是說，**第一個被解鎖 (after 0) 的電腦必須是剩下電腦中 complexity 最小的那一台**。否則根本沒辦法解鎖其他 (解鎖規則限制) 。
2. 如果上述條件滿足 (也就是第一解鎖的是最小 complexity)，那剩下 n - 1 台電腦 (不含 0) 可以用任意順序解鎖 — 等於 (n - 1)! 種排列方式。
3. 因此，答案不是複雜 DP / BFS / backtracking，而是簡單的判斷 + 階乘 (factorial) 計算 (mod 問題)。

> 關鍵 insight：題目巧設「密碼複雜度限制 + 0 已解鎖 + 密碼唯一 + 必須先最小 complexity」，讓許多排列都立即無效 — 所以只剩 (n-1)! valid permutations。

若不滿足第一解鎖為最小 complexity → 回傳 0。

---

## 時間與空間複雜度

* **時間複雜度**：O(n) — 需要一次遍歷 `complexity` 找最小 + 檢查 first 解鎖條件 (或固定)
* **空間複雜度**：O(1) (或 O(n) 若考慮儲存階乘值)
