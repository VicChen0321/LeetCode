# 3349. Adjacent Increasing Subarrays Detection I

**LeetCode Link:** [3349. Adjacent Increasing Subarrays Detection I](https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/)
**Difficulty:** Easy
**Tags:** Array, Greedy, Two Pointers, Sliding Window

---

## 題目描述

給你一個整數陣列 `nums` 和一個整數 `k`。
請你判斷是否存在兩個**相鄰**的、長度都是 `k` 的 **嚴格遞增** 子陣列。

具體條件：

* 兩個子陣列都是長度 `k` 且嚴格遞增（每個元素都比前一個大）。
* 子陣列必須是相鄰的，也就是如果第一個子陣列起始於 `a`，第二個子陣列必須起始於 `b = a + k`，兩者沒有重疊也無間隔。
* 若存在這樣一對子陣列，回傳 `true`；否則回傳 `false`.

---

## 範例

**Example 1:**
Input: `nums = [2,5,7,8,9,2,3,4,3,1]`, `k = 3` → Output: `true`
解釋：從索引 2 開始的子陣列 `[7,8,9]` 和從索引 5 開始的 `[2,3,4]` 分別是嚴格遞增，且第二個子陣列從第一個結束之後接續（5 = 2 + 3）。

**Example 2:**
Input: `nums = [1,2,3,4,4,4,4,5,6,7]`, `k = 5` → Output: `false`

---

## 解法概念 / 核心思路

直接檢查每對可能的相鄰子陣列會是 O(n·k)，對於 n、k 都不大情況下可以通過（n 最多 100）

但有更優雅的方法是：在遍歷時維護 **連續嚴格遞增區段的長度**，並在每個段落結束時用一些局部條件做判斷。這是題解常用的方式

具體技巧：

* 使用兩個變數：

  * `incr`：當前嚴格遞增區段長度（包含當前元素）
  * `pre`：上一個遞增區段的長度
* 遍歷陣列從左到右：

  * 若 `nums[i] > nums[i-1]`，則 `incr++`，否則遇斷點就把 `pre = incr`，`incr = 1`
  * 在每一步（或每次更新後）檢查：

    * `incr / 2 >= k` → 這代表當前一段本身就可以拆成兩個相鄰子陣列
    * 或 `min(pre, incr) >= k` → 利用前一段與這一段的尾與頭作兩個子陣列
  * 若任一條件成立，立即返回 `true`

這種方法只需 O(n) 時間、O(1) 空間。 

---

## 時間與空間複雜度

* **時間複雜度：** O(n) — 單次遍歷整個陣列
* **空間複雜度：** O(1) — 只用了幾個輔助變數