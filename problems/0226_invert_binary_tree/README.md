# 0226 - Invert Binary Tree

**LeetCode Link:** [https://leetcode.com/problems/invert-binary-tree/](https://leetcode.com/problems/invert-binary-tree/)
**Difficulty:** Easy
**Tags:** Tree, Binary Tree, DFS, BFS, Recursion

---

## 題目描述

給你一棵**二元樹（binary tree）**的根節點 `root`，
請將整棵樹**左右反轉（invert / mirror）**，並回傳反轉後的根節點。

* 對每一個節點，交換其左子樹與右子樹
* 可能是空樹
* 不需要建立新節點，直接原地操作

### 範例

* Input: `root = [4,2,7,1,3,6,9]`
  Output: `[4,7,2,9,6,3,1]`

```
    4              4
   / \            / \
  2   7    →     7   2
 / \ / \        / \ / \
1  3 6  9      9  6 3  1
```

* Input: `root = []` → Output: `[]`

* Input: `root = [1]` → Output: `[1]`

---

## 解法概念

這題本質就是 **Tree Traversal + Swap**，沒有任何陷阱。

### 方法：DFS（Recursion）

#### 核心想法

* 對每一個節點做一樣的事：

  1. 交換左右子節點
  2. 對左右子樹遞迴處理

#### 演算法步驟

1. 若 `root == null`，直接回傳 `null`
2. 交換 `root.left` 與 `root.right`
3. 對 `root.left` 遞迴 invert
4. 對 `root.right` 遞迴 invert
5. 回傳 `root`

#### 關鍵 insight

* 每個節點的處理邏輯完全一樣 → 非常適合遞迴
* 不管是 Preorder / Postorder 都能做，只要 swap 在同一層
* 這題不是考邏輯，是考你對 Tree 的基本操作熟不熟

> 小提示：
> 若你能清楚說出「每一層都在做什麼」，這題就已經會了。

---

## 時間與空間複雜度

* **時間複雜度**：O(n)（每個節點走一次）
* **空間複雜度**：

  * 平均：O(h)（遞迴深度，h 為樹高）
  * 最差（skewed tree）：O(n)
