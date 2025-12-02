# 0055. Jump Game

**LeetCode Link:** [https://leetcode.com/problems/jump-game/](https://leetcode.com/problems/jump-game/)
**Difficulty:** Medium
**Tags:** Greedy, Array, DP

---

## 題目描述

給你一個整數陣列 `nums`，其中 `nums[i]` 代表你從 index `i` 最多可以往右跳的距離。
請判斷：**是否能從 index 0 跳到最後一個 index？**

* 你每次可以選擇跳 1 ~ nums[i] 步。
* 只要能到達或超過最後位置，就視為成功。

### 範例

* **Input:** nums = [2,3,1,1,4]
  **Output:** true
  因為：0 → 1 → 4

* **Input:** nums = [3,2,1,0,4]
  **Output:** false
  走到 index=3 時最大跳躍為 0，無法跨過 4。

---

## 解法概念

### 方法：Greedy（維護能到達的最遠位置）

這題最關鍵的觀念是：

> **只要從左到右走的過程中，你能持續更新「最遠可達距離」，就能判定能否到最後。**

核心邏輯：

1. 建立 `maxReach`，表示目前能走到的最遠 index。
2. 從左到右遍歷每個 i：

   * 若 **i > maxReach**，表示你根本走不到 i → 直接 return false。
   * 否則更新 `maxReach = max(maxReach, i + nums[i])`。
3. 若 `maxReach >= 最後 index` 則 return true。

#### 直覺示意

* `maxReach` 像是你能走到的邊界。
* 每到一個位置，你可以用 `nums[i]` 把這個邊界推得更遠。
* 只要某一步遇到「邊界到不了這個點」，就 GG。

#### 常犯錯誤

* 以為要 DFS 或 DP → 時間會太慢。
* 覺得每次跳要決策實際跳哪格 → 不需要，只需要更新能到的最遠格子。

---

## 時間與空間複雜度

* **時間複雜度**：O(n)
* **空間複雜度**：O(1)
