# 39 Combination Sum

**LeetCode Link:** [39. Combination Sum](https://leetcode.com/problems/combination-sum/)
**Difficulty:** Medium
**Tags:** Backtracking, Array, DFS

---

## 題目描述

給定一個 **無重複元素** 的整數陣列 `candidates` 和一個目標值 `target`。
找出所有 **數字總和為 target 的組合**。

規則：

* `candidates` 中的每個數字可以 **重複使用不限次數**
* **組合內的數字順序不影響結果**
* 結果中不可包含重複組合

---

### 範例

**Input**

```
candidates = [2,3,6,7], target = 7
```

**Output**

```
[[2,2,3],[7]]
```

**Input**

```
candidates = [2,3,5], target = 8
```

**Output**

```
[[2,2,2,2],[2,3,3],[3,5]]
```

---

## 解法概念

### 方法：DFS + Backtracking

* 使用 **深度優先搜尋（DFS）+ 回溯（Backtracking）**
* 每次從當前 index 開始嘗試加入數字（避免重複組合）
* 若目前總和 `sum > target` → 剪枝（停止探索）
* 若 `sum == target` → 加入答案

流程：

1. 遞迴函式 `dfs(start, target, path)`
2. 若 `target == 0` → 找到解
3. 遍歷 `start` 至結尾：

   * 選擇當前數字
   * 遞迴同 index（允許重複）
   * 回溯移除當前數字

---

## 時間與空間複雜度

| 項目        | 複雜度                 |
| --------- | ------------------- |
| **時間複雜度** | O(2ⁿ)（最差情況需要遍歷所有組合） |
| **空間複雜度** | O(target)（遞迴深度）     |

---

## 核心關鍵

* **回溯（Backtracking）模板題**
* 同一層從 `start` 開始避免重複
* 允許重複使用 → 遞迴時 `i` 不加一
* 遇到 `target < 0` 必須剪枝

---

## 優化方向

* 可先排序陣列 → 提早剪枝
* 若資料量大，可使用動態規劃（DP）優化版本（不過本題以 DFS 為最佳）
