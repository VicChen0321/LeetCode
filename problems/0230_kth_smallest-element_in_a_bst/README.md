# 230 Kth Smallest Element in a BST

**LeetCode Link:**
[230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

**Difficulty:** Medium
**Tags:** Binary Search Tree, DFS, In-order Traversal

---

## 題目描述

給定一個 **二元搜尋樹（BST）** 的根節點 `root`，以及一個整數 `k`，請找出 BST 中第 `k` 小的元素。

---

### 範例

**Input**

```
root = [3,1,4,null,2], k = 1
```

**Output**

```
1
```

**解釋**

* BST 中第 1 小的元素是 1

---

**Input**

```
root = [5,3,6,2,4, null,null,1], k = 3
```

**Output**

```
3
```

---

## 解法概念

### 方法一：中序遍歷（In-order Traversal）

BST 的中序遍歷結果是 **遞增排序**。

1. 使用 DFS 進行中序遍歷
2. 遍歷時累計計數，當計數等於 k 時，返回該節點值

---

### 方法二：進階（利用節點計數）

1. 樹中每個節點保存 **左子樹節點數**
2. 比較 k 與左子樹數量判斷：

   * k <= 左子樹節點數 → 在左子樹
   * k = 左子樹節點數 + 1 → 當前節點即答案
   * k > 左子樹節點數 + 1 → 在右子樹，調整 k

> 適合 BST 重複查詢 kth 小元素時用

---

## 時間與空間複雜度

| 項目        | 複雜度             |
| --------- | --------------- |
| **時間複雜度** | O(H + k)，H 為樹高度 |
| **空間複雜度** | O(H)（遞迴棧）       |

---

## 核心關鍵

* **BST 的中序遍歷** → 遞增序列
* 記住 **k 遞減或計數累加**
* 可以用 **迭代 + stack** 代替遞迴
* 面試進階題：若多次查詢 kth 小 → 可以在節點存子樹大小加速
