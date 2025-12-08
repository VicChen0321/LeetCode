# 2211. Count Collisions on a Road

**LeetCode Link:** [https://leetcode.com/problems/count-collisions-on-a-road/](https://leetcode.com/problems/count-collisions-on-a-road/)
**Difficulty:** Medium
**Tags:** String, Simulation, Stack / Greedy

---

## 題目描述

給你一條道路上的車輛狀態字串 `directions`，每個字元表示一輛車的行進方向：

* `'L'`：向左移動
* `'R'`：向右移動
* `'S'`：停止不動（stationary）

每次兩台車相撞後：

* 它們都會變成 `'S'`（停止）
* 每次撞擊會帶來 **1 次 collision 計數**

你需要計算：整個過程中發生多少次 collision。

碰撞規則重點：

* `'R'` 往右 + `'L'` 往左 → 正面相撞
* `'R'` 往右 + `'S'` → `'R'` 撞上 `'S'`
* `'S'` + `'L'` 往左 → `'L'` 撞上 `'S'`
* 停止後的 `'S'` 不再移動，但可能被其他車撞上

---

### 範例

**Example 1**

* Input: `"RLRSLL"`
* Output: `5`
  解釋：多次正面 / 撞上停止車輛產生 5 次碰撞。

**Example 2**

* Input: `"LLRR"`
* Output: `0`
  解釋：所有車都往外側，不會相撞。

---

## 解法概念

### 方法：Greedy / Simulation by Counting

本題的核心並不是逐步模擬車子移動，而是觀察**哪些車一定會產生碰撞**。

### 重要觀察（關鍵 Insight）

1. **左側連續的 L 不會被撞**（因為外面沒車）
2. **右側連續的 R 不會被撞**（因為外面沒車）
3. 中間其他方向的車，只要：

   * 出現 `'L'` → 左移，右邊如果是 `'R'` 或 `'S'` → 會撞
   * 出現 `'R'` → 右移，左邊如果是 `'S'` → 會撞

   → 最終都會停下來並變成 `'S'`

### 更簡化觀念

「只要是會被迫停止的車（非邊界 L / R），就一定會製造一次 collision。」

具體邏輯：

1. 去掉 **左端全部的 `'L'`**
2. 去掉 **右端全部的 `'R'`**
3. 剩下的車，不管是 `'L'`、`'R'` 或 `'S'`：

   * `'L'` 撞 `'S'`
   * `'R'` 撞 `'S'`
   * `'R'` 撞 `'L'`
   * 只要不是邊界的自由車，都會產生碰撞

👉 **除了邊界 L / R 外，每一台行進中的車都會製造 1 次 collision**。

因此：

> **答案 = 剩餘車輛中非 'S' 的總數**

---

## 解法步驟

1. 找出第一個不是 `'L'` 的位置 `leftBound`
2. 找出最後一個不是 `'R'` 的位置 `rightBound`
3. 在 `[leftBound, rightBound]` 之間，計算每個 `'L'` 或 `'R'`（因為都會撞）
4. `'S'` 不會新增 collision

---

## 時間與空間複雜度

* **時間複雜度**：O(n) — 單次掃描
* **空間複雜度**：O(1) — 只用常數變數
