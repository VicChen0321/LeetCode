# 100 Same Tree

**LeetCode Link:** [100. Same Tree](https://leetcode.com/problems/same-tree/)  
**Difficulty:** Easy  
**Tags:** Tree, DFS, Recursion, BFS

---

## 題目描述
給定兩棵二元樹的根節點 `p` 和 `q`，判斷這兩棵樹是否**相同**。  
相同定義：結構相同且對應節點值相同。

### 範例
- Input: `p = [1,2,3]`, `q = [1,2,3]` → Output: `true`  
- Input: `p = [1,2]`, `q = [1,null,2]` → Output: `false`  
- Input: `p = [1,2,1]`, `q = [1,1,2]` → Output: `false`

---

## 解法概念

### 方法 1：遞迴（DFS / Preorder 比較）
- 如果 `p`、`q` 同時為 `null` → 相同  
- 若其中一個為 `null`（另一個不是） → 不同  
- 若 `p.val != q.val` → 不同  
- 否則遞迴比較 `p.left` vs `q.left` 與 `p.right` vs `q.right`  
- 直觀、程式碼短、面試常用

### 方法 2：迭代（BFS / Queue 或 Stack）
- 用兩個 queue/stack 同步 BFS/DFS 遍歷兩棵樹
- 每次 pop 兩個節點做上面相同的檢查條件
- 優點：避免遞迴深度限制（大深度樹場景）