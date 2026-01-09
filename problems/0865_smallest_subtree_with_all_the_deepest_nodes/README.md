# 865. Smallest Subtree with all the Deepest Nodes

**LeetCode Link:** [865. Smallest Subtree with all the Deepest Nodes](https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/)

**Difficulty:** Medium

**Tags:** Tree, Depth-First Search, Breadth-First Search, Binary Tree

---

## 題目描述

給定一個二元樹的根節點 `root`，回傳一個包含所有「最深節點」的**最小子樹**。

* **最深節點**：指離根節點距離最遠的那些節點。
* **最小子樹**：如果一個節點包含所有最深節點，且它是所有符合條件的節點中深度最大的（即位置最低的），它就是答案。

### 範例

* **Input:** root = [3,5,1,6,2,0,8,null,null,7,4] → **Output:** [2,7,4]
* 最深節點是 7 和 4（深度為 3）。
* 包含 7 和 4 的最小子樹根節點是 2。

* **Input:** root = [1] → **Output:** [1]
* 最深節點是 1 自己。

* **Input:** root = [0,1,3,null,2] → **Output:** [2]
* 最深節點是 2，包含它的最小子樹就是它本身。

---

## 解法概念

這題的核心在於找出**最深節點們的最近公共祖先（LCA）**。

### 方法：遞迴深度回傳法（One-pass DFS）

我們可以使用 DFS 遍歷整棵樹。每個節點不僅回傳它所包含的最深節點所在的子樹根，還需要同時回傳該子樹的「最大深度」。

1. **定義遞迴函數**：函數 `dfs(node)` 會回傳一個組合資訊：`{該節點下的最大深度, 該深度對應的目標子樹}`。
2. **終止條件**：如果遇到空節點（null），回傳深度 0 且子樹為 null。
3. **遞迴比較**：

* 取得左子樹回傳的 `{left_depth, left_node}`。
* 取得右子樹回傳的 `{right_depth, right_node}`。

1. **判斷邏輯**：

* **Case 1 (left_depth == right_depth)**：代表當前節點的左右兩側都有最深節點。根據定義，當前節點就是這兩群最深節點的「最近公共祖先」，回傳 `{left_depth + 1, node}`。
* **Case 2 (left_depth > right_depth)**：代表最深節點都在左邊，回傳 `{left_depth + 1, left_node}`。
* **Case 3 (left_depth < right_depth)**：代表最深節點都在右邊，回傳 `{right_depth + 1, right_node}`。

> **關鍵 Insight**：
> 我們不需要先找出最深節點是誰。只要在回傳深度時，當左右深度一致，就代表我們找到了目前的「候選公共祖先」。

---

## 時間與空間複雜度

* **時間複雜度**：
* 每個節點僅被訪問一次（DFS）。

* **空間複雜度**：
* 為樹的高度（遞迴調用棧的深度）。在最壞情況下（斜長樹）為 ，平衡樹則為 。
