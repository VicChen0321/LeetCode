# 103 Binary Tree Zigzag Level Order Traversal

**LeetCode Link:**
[103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

**Difficulty:** Medium
**Tags:** Tree, BFS, Queue, Deque

---

## 題目描述

給定一個二元樹的根節點 `root`，請回傳其節點值的 **Zigzag 層序遍歷結果**：

* 第 1 層：從左到右
* 第 2 層：從右到左
* 第 3 層：從左到右
* 依此類推，方向交錯。

---

### 範例

**Input**

```
    3
   / \
  9  20
    /  \
   15   7
```

**Output**

```
[
  [3],
  [20, 9],
  [15, 7]
]
```

---

## 解法概念

### 方法：BFS + level index 判斷方向

1. 使用 queue 進行 BFS 層序遍歷
2. 用 `level % 2` 判斷奇偶層：

   * 偶數層（index 0, 左→右）：正常加入 list
   * 奇數層（index 1, 右→左）：可以用 `reverse` 或直接插入 list 之前端
3. 在每層處理完成後加入結果

---

## 時間與空間複雜度

| 項目        | 複雜度  |
| --------- | ---- |
| **時間複雜度** | O(n) |
| **空間複雜度** | O(n) |

---

## 核心關鍵

* 基於 **層序遍歷（BFS）**
* 使用 `level` 或 `boolean` 控制方向
* 奇數層可以用 `Collections.reverse()` 或 `deque` 優化插入
