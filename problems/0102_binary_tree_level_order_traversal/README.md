# 102 Binary Tree Level Order Traversal

**LeetCode Link:**
[102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

**Difficulty:** Medium
**Tags:** Tree, Breadth-First Search (BFS), Queue

---

## 題目描述

給定一個二元樹的根節點 `root`，請回傳其節點值的 **層序遍歷結果**（從上到下、從左到右）。

---

### 範例

**Input**

```
    3
   / \
  9  20
     / \
    15  7
```

**Output**

```
[
  [3],
  [9, 20],
  [15, 7]
]
```

---

## 解法概念

### 方法：BFS + Queue

使用 BFS（廣度優先搜尋）逐層遍歷：

1. 使用 `queue` 儲存當前層的節點
2. 每次迴圈取出該層所有節點，存入臨時 list
3. 再把這些節點的 children 加入 queue（下一層）
4. 直到 queue 空為止

---

## 時間與空間複雜度

| 項目        | 複雜度                   |
| --------- | --------------------- |
| **時間複雜度** | O(n)，每個節點遍歷一次         |
| **空間複雜度** | O(n)，queue 最多可裝一層所有節點 |

---

## 核心關鍵

* 典型 **BFS 應用**
* 善用 **queue 儲存下一層節點**
* 每層用 `size` 控制迴圈次數
* 經典層序遍歷，常與 level sum、zigzag traversal 一併考
