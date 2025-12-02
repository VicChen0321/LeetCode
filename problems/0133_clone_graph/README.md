# 133 Clone Graph

**LeetCode Link:** [133. Clone Graph](https://leetcode.com/problems/clone-graph/)  
**Difficulty:** Medium  
**Tags:** Graph, DFS, BFS, Hash Table

---

## 題目描述

給定一個無向圖的節點 `node`，每個節點包含一個整數值 `val` 和鄰居節點列表 `neighbors`。  
請返回 **圖的深拷貝**（Clone），即建立一個新的圖，結構與原圖相同，但節點是全新物件。  

- 節點數量 ≤ 100  
- 節點值為 1 ~ 100  
- 圖可能是連通或不連通  

### 範例

- Input: `node = [[2,4],[1,3],[2,4],[1,3]]`  
- Output: 克隆後的新圖，結構相同

---

## 解法概念

### 方法 1：DFS + HashMap

- 使用 HashMap `oldNode -> newNode` 來避免重複克隆
- 遞迴過程：
  1. 若 node 為 null → return null  
  2. 若 node 已存在於 HashMap → return 已克隆節點  
  3. 否則：
     - 創建新節點 clone
     - 存入 HashMap
     - 遞迴克隆所有鄰居，加入 clone.neighbors

### 方法 2：BFS + HashMap

- 用 Queue 遍歷圖
- 對每個節點：
  - 若未克隆 → 創建並放入 HashMap
  - 對鄰居：
    - 若未克隆 → 克隆並入 Queue
    - 加入 clone.neighbors  

> **核心概念**：防止循環造成無限遞迴或重複克隆 → 用 HashMap 記錄已處理節點

---

## 時間與空間複雜度

- **時間複雜度：** O(V + E)  
  - V = 節點數量，E = 邊數  
  - 每個節點和邊只訪問一次
- **空間複雜度：** O(V)  
  - HashMap 儲存所有節點的 clone  
  - DFS recursion 也可能使用 O(V) stack
