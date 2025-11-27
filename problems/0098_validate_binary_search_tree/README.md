# 98 Validate Binary Search Tree

**LeetCode Link:**
[98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)

**Difficulty:** Medium
**Tags:** Tree, DFS, Recursion

---

## 題目描述

給定一個二元樹的根節點 `root`，判斷它是否是一個 **有效的二元搜尋樹（BST）**。

BST 必須符合以下條件：

1. 左子樹所有節點的值 **小於根節點**
2. 右子樹所有節點的值 **大於根節點**
3. 左右子樹也都必須是 BST

---

### 範例

**Input**

```
    2
   / \
  1   3
```

**Output**

```
true
```

---

**Input**

```
    5
   / \
  1   4
     / \
    3   6
```

**Output**

```
false
```

**解釋：** 因為 `4` 的左子節點 `3` 應該 < `5`，但它在右子樹中。

---

## 解法概念

### 方法一：DFS（上下界限制）

在 DFS 過程中，針對每個節點傳遞允許的值範圍：

```
左子樹：max 更新為目前節點值
右子樹：min 更新為目前節點值
```

若出現節點值違反 min/max 範圍，則不是 BST。

### 方法二：In-order Traversal

BST 的 中序遍歷結果一定是遞增的。

---

## 時間與空間複雜度

| 項目        | 複雜度                   |
| --------- | --------------------- |
| **時間複雜度** | O(n)（遍歷所有節點）          |
| **空間複雜度** | O(h)（遞迴 stack，h 為樹高度） |

---

## 核心關鍵

* 避免只比較 parent（例：只看 `node.left < node < node.right` 是錯的）
* 正確做法是用 **全域範圍**（min/max）限制節點值
* 初始範圍使用 `Long.MIN_VALUE` 和 `Long.MAX_VALUE`（Java）避免 overflow
