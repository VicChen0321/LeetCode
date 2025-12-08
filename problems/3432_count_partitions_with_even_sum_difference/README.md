# 3432. Count Partitions with Even Sum Difference

**LeetCode Link:** [https://leetcode.com/problems/count-partitions-with-even-sum-difference/](https://leetcode.com/problems/count-partitions-with-even-sum-difference/)
**Difficulty:** Easy / Medium（偏向簡單）
**Tags:** Array, Math, Prefix Sum

---

## 題目描述

給你一個整數陣列 `nums`，長度為 `n`。你需要在這個陣列中選擇一個 切割點 (partition index) `i`（`0 <= i < n - 1`），將陣列分成兩個非空子陣列：

* 左子陣列為 `nums[0..i]`
* 右子陣列為 `nums[i+1..n-1]`

計算這兩個子陣列之和（sum_left, sum_right），然後計算它們的差值 (left_sum − right_sum)。

**任務**：統計有多少種切割方式使得差值為 **偶數 (even)**。

注意：

* 切割點 i 不能在最後 (i < n - 1)，保證左右兩邊都非空。

---

### 範例

* Input: `nums = [10, 10, 3, 7, 6]` → Output: `4`
  解釋：共有 4 種 partition 使得 (left_sum − right_sum) 是偶數。

* Input: `nums = [1,2,2]` → Output: `0`
  解釋：沒有切割點可以讓差值是偶數。

* Input: `nums = [2,4,6,8]` → Output: `3`
  解釋：所有可能的 partition 都符合條件。

---

## 解法概念

### 方法：Prefix Sum + Math Parity 判斷

關鍵觀察／推導：

* 設整體和為 `S = sum(nums)`。
* 對於某個切割點 i，左子陣列和為 `L`，右子陣列和為 `R = S − L`。
* 差值为 `D = L − R = L − (S − L) = 2L − S`。
* 因此 `D` 的奇偶性只取決於 `S` 的奇偶性與 `2L` 的奇偶性。
* `2L` 一定是偶數 (因為乘 2)，所以 **D** 的奇偶性等於 `S` 的奇偶性。

換句話說，**只要整體 sum `S` 是偶數**，那麼對於 **任意合法的 partition**，`(left_sum − right_sum)` 都一定是偶數。

由於共有 `n - 1` 個合法 partition (因為分割點 i 從 0 到 n−2)，所以：

* 若 `S` 是偶數 → 回傳 `n - 1`
* 若 `S` 是奇數 → 回傳 0

這樣可以在 O(1) 時間 (實際 O(n) 計算 sum) 直接得出答案。

> **關鍵 insight**：不要對每一個 partition 都分別計算 — 整體 sum 的奇偶性決定所有 partition 差值的奇偶性。

---

## 時間與空間複雜度

* **時間複雜度**：O(n) — 遍歷一次計算陣列總和即可。
* **空間複雜度**：O(1) — 只用固定數量變數。
