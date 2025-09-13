# 572 Subtree of Another Tree

**LeetCode Link:** [572. Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/)  
**Difficulty:** Easy  
**Tags:** Tree, DFS, Recursion

---

## 題目描述
給定兩棵二元樹：一棵大樹 `root` 和一棵小樹 `subRoot`。  
判斷 `subRoot` 是否在 `root` 的某個子節點下面完全作為一棵子樹出現。  

「子樹」定義為某個節點及其所有後代節點結構與值都與 `subRoot` 一致。  
如果 `subRoot` 完全等於 `root`，也算是子樹。

---

## 解法概念

### 方法：遞迴 + 比較
1. 定義一個輔助函數 `isSameTree(p, q)` 用來比對兩棵樹是否完全相同（結構 + 節點值）。  
   - 如果 `p` 和 `q` 都是 `null` → 相同  
   - 如果一個是 `null` 另一個不是 → 不同  
   - 若節點值相同，則遞迴比對左右子樹  

2. 主函數 `isSubtree(root, subRoot)`：
   - 如果 `root` 是空 → 回傳 false（因為 `subRoot` 一定非空）  
   - 如果從 `root` 出發的子樹與 `subRoot` 相同 → 回傳 true  
   - 否則，遞迴檢查 `root.left` 是否包含 `subRoot` 或 `root.right` 是否包含 `subRoot`

---

## 時間與空間複雜度
- **時間複雜度：** O(m * n)  
  - `m` = `root` 的節點數  
  - `n` = `subRoot` 的節點數  
  因為對 `root` 中每一節點都可能比對一遍 `subRoot`  
- **空間複雜度：** O(h)  
  - `h` 為 `root` 的高度，因為遞迴呼叫棧深度為樹的高度  

---

## 關鍵重點
- `isSameTree` 必須比較**結構與節點值**  
- 在 `isSubtree` 每個節點都要試 `isSameTree`  
- 處理邊界情況：`root` 或 `subRoot` 為空時怎麼辦  