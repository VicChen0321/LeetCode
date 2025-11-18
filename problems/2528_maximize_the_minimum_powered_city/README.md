# 2528. Maximize the Minimum Powered City

**LeetCode Link:** [2528. Maximize the Minimum Powered City](https://leetcode.com/problems/maximize-the-minimum-powered-city/)
**Difficulty:** Hard
**Tags:** Binary Search, Sliding Window, Greedy, Prefix Sum

---

## 題目描述

有 `n` 座城市排成一列（0-indexed），`stations[i]` 表示第 `i` 座城市原本的電站數量。

每座城市的「覆蓋範圍」為距離 `r` 以內的所有城市，也就是說：
第 `i` 座城市的「供電量」是

```
power[i] = sum(stations[j]) for all j where |i - j| <= r
```

現在你可以 **額外建造 `k` 座電站**，任意分配到城市中。
請回傳在最優配置下，所有城市的最小供電量的「最大可能值」。

---

## 範例

### 範例 1

```
Input: stations = [1,2,4,5,0], r = 1, k = 2
Output: 5
```

**解釋：**

* 初始 power = [3, 7, 11, 9, 5]
* 若在 city 1 與 city 2 各加 1 座，
  → power = [5, 9, 13, 11, 7]
  → 最小供電量為 5

### 範例 2

```
Input: stations = [4,4,4,4], r = 0, k = 3
Output: 7
```

**解釋：**

* r=0 代表城市只受到自己影響。
* 將三個新電站分配為 [5,6,7,4] → 最小供電量為 5，不最佳。
* 若配置為 [7,4,4,4] → 最小供電量為 4。
* 最佳方案是平均分配，使最小值達 7。

---

## 解法概念

### 方法：**Binary Search + Sliding Window (Prefix Sum 模擬)**

#### 思路概覽：

我們要「最大化最小值」，這通常是 **二分搜尋答案** 的典型模式。

1. **定義檢查函式 `can(mid)`**
   檢查在給定的最小供電量 `mid` 下，是否能用 ≤ k 個新電站達成。

2. **用 Sliding Window 計算 power[i]**

   * 先用 prefix sum 計算出初始每個城市的供電量。
   * 當遇到城市的供電量不足 (`power[i] < mid`) 時，就在覆蓋範圍最右端加電站補足。

3. **模擬加站過程**

   * 用一個額外的 `added[]` 陣列記錄在哪裡加了電站。
   * 透過 window sum 模擬影響，確保每座城市都 ≥ mid。
   * 若加站總數超過 k，表示無法達成。

4. **二分搜尋範圍**

   * low = min(power)，high = max(power) + k
   * 最後回傳可行的最大 mid。

---

## 時間與空間複雜度

* **時間複雜度：** O(n log M)，M 為可能的供電量上限（由二分搜尋決定）
* **空間複雜度：** O(n)，用於模擬新增電站

---

## 關鍵重點

* 「最大化最小值」→ 通常是 **二分搜尋答案 + 檢查可行性**
* `can(mid)` 利用 **滑動窗口 / prefix sum** 模擬局部補足
* 注意覆蓋範圍 `r` 對城市供電量的影響範圍
* 時間效率重點：不要每次都重新計算整個陣列，而是 **O(n)** 模擬即可
