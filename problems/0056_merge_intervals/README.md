# 0056. Merge Intervals

**LeetCode Link:** [https://leetcode.com/problems/merge-intervals/](https://leetcode.com/problems/merge-intervals/)
**Difficulty:** Medium
**Tags:** Array, Sorting, Interval

---

## 題目描述

給定一個由區間組成的陣列 `intervals`，每個區間是 `[start, end]`，請將 **所有重疊的區間合併**，並返回一個 **不重疊的區間陣列**。

注意事項：

* 每個區間的 `start <= end`
* 輸入可能無序
* 合併後的區間順序可以按起點排序

---

### 範例

**Example 1**

* Input: `[[1,3],[2,6],[8,10],[15,18]]`
* Output: `[[1,6],[8,10],[15,18]]`
  解釋：

  * `[1,3]` 和 `[2,6]` 重疊 → 合併成 `[1,6]`
  * `[8,10]`、`[15,18]` 不重疊

**Example 2**

* Input: `[[1,4],[4,5]]`
* Output: `[[1,5]]`
  解釋：

  * `[1,4]` 與 `[4,5]` 接觸 → 合併成 `[1,5]`

---

## 解法概念

### 方法：Sorting + Merge

核心思路：

> 將區間依起點排序，然後線性掃描合併重疊區間。

步驟：

1. **排序**

   * 依區間 `start` 升序排序
   * 例如 `[[1,3],[2,6],[8,10]]` → 已排序 `[1,3],[2,6],[8,10]`

2. **初始化結果 list**

   * 用 `merged = []`
   * 遍歷每個區間 `interval`

3. **檢查重疊**

   * 若 `merged` 為空或 `merged[-1][1] < interval[0]` → 不重疊，直接 append
   * 否則 → 有重疊

     * 更新 `merged[-1][1] = max(merged[-1][1], interval[1])`
     * 這樣合併當前區間

4. **線性掃描結束**

   * 返回 `merged` 即為合併後的區間陣列

> **關鍵 insight**：排序後，只需線性掃描一次就能判斷重疊 → O(N log N) + O(N) 時間。

---

## 時間與空間複雜度

* **時間複雜度**：O(N log N) → 排序 + 線性掃描
* **空間複雜度**：O(N) → 儲存結果（就地修改可降到 O(1)）
