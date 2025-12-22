# 0110 - Balanced Binary Tree

**LeetCode Link:** [https://leetcode.com/problems/balanced-binary-tree/](https://leetcode.com/problems/balanced-binary-tree/)
**Difficulty:** Easy
**Tags:** Tree, Binary Tree, DFS, Recursion

---

## 題目描述

給你一棵**二元樹（binary tree）**的根節點 `root`，
請判斷這棵樹是否為**高度平衡二元樹（height-balanced）**。

一棵高度平衡的二元樹定義為：

* 任意節點的左右子樹高度差 **不超過 1**
* 左右子樹本身也必須是平衡的

> 高度指的是：從該節點到最深葉節點的邊數或節點數（一致即可）

### 範例

* Input: `root = [3,9,20,null,null,15,7]` → Output: `true`
  左右子樹高度差為 1，符合條件

* Input: `root = [1,2,2,3,3,null,null,4,4]` → Output: `false`
  某節點左右子樹高度差 > 1

* Input: `root = []` → Output: `true`
  空樹視為平衡

---

## 解法概念

這題重點在於：**你不能單純算高度，否則會重複計算**。

### 方法：DFS（Bottom-up Recursion）

#### 核心想法

* 從**葉節點往上**計算高度
* 一旦發現某個子樹不平衡，立刻往上回傳「失敗訊號」

我們讓遞迴函式回傳兩種資訊合一的結果：

* 正常情況：回傳該節點的高度
* 不平衡：回傳一個特殊值（例如 `-1`）

#### 演算法步驟

1. 定義遞迴函式 `height(node)`：

   * 若 `node == null` → 回傳 `0`
2. 遞迴取得：

   * `leftHeight = height(node.left)`
   * `rightHeight = height(node.right)`
3. 若任一子樹回傳 `-1` → 直接回傳 `-1`
4. 若 `abs(leftHeight - rightHeight) > 1` → 回傳 `-1`
5. 否則回傳 `max(leftHeight, rightHeight) + 1`
6. 最終只要判斷 `height(root) != -1`

#### 關鍵 insight

* **高度計算 + 平衡檢查一定要同時做**
* Top-down（每個節點各算高度）會變成 O(n²)
* Bottom-up 才是正解

> 小提示：
> 看到「平衡樹判斷」，九成是 Bottom-up DFS。

---

## 時間與空間複雜度

* **時間複雜度**：O(n)（每個節點最多走一次）
* **空間複雜度**：O(h)（遞迴深度，h 為樹高，最差 O(n)）
