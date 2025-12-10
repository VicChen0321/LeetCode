# 57. Insert Interval

**LeetCode Link:** [https://leetcode.com/problems/insert-interval/](https://leetcode.com/problems/insert-interval/)
**Difficulty:** Medium
**Tags:** Array, Interval

---

## 題目描述

給一組 **不重疊、已排序（依 start）** 的區間 `intervals`，再給一個 `newInterval`。
請把 `newInterval` 插入後，使整個區間列表仍然是 **不重疊且排序** 的，必要時需進行合併。

你要回傳合併後的新區間列表。

* 原區間皆為 `[[s1, e1], [s2, e2], ...]`
* 所有區間 **不重疊** 且已排序
* 新插入後若有重疊需合併成一個較大的區間

### 範例

* **Input:**
  intervals = [[1,3],[6,9]], newInterval = [2,5]
  **Output:** [[1,5],[6,9]]
  解釋：newInterval = [2,5] 與 [1,3] 重疊，合併成 [1,5]。

* **Input:**
  intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
  **Output:** [[1,2],[3,10],[12,16]]
  解釋：[4,8] 會與 [3,5], [6,7], [8,10] 合併成 [3,10]。

---

## 解法概念

### 方法：線性掃描 + 合併區間（Greedy Interval Merge）

1. **把 newInterval 前面不重疊的區間先加入結果**

   * 如果目前區間的 end < newInterval.start → 不重疊，直接加入 result。

2. **處理與 newInterval 重疊的部分**

   * 若區間與 newInterval 有交集 → 合併（更新 newInterval 的 start、end）。
   * 合併條件：`interval.start <= newInterval.end`

3. **把更新後的 newInterval 加入結果**

4. **把 newInterval 後面不重疊的所有區間加入結果**

這個流程一次走完 intervals，不需要排序。

#### 直覺示意

```
[---A---]    [---B---]
        \    /
       newInterval
```

* 不重疊 A → 直接丟入結果
* 有重疊的全部融合進 newInterval
* 不重疊 B → 丟入結果

> 關鍵 insight：
> 利用「原本已排序且不重疊」的性質，只需一次線性掃描就能完成所有合併。

---

## 時間與空間複雜度

* **時間複雜度**：O(n) — 單次掃描所有區間
* **空間複雜度**：O(n) — 結果需要輸出新陣列
