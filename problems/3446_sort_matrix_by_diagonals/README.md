# 3446 Sort Matrix by Diagonals

**LeetCode Link:** [3446. Sort Matrix by Diagonals](https://leetcode.com/problems/sort-matrix-by-diagonals/)  
**Difficulty:** Medium  
**Tags:** Matrix, Sorting, Heap (Priority Queue)

---

## 題目描述
給定一個 `n x n` 的矩陣 `grid`，需要將矩陣沿對角線排序：

- **右上三角**（不含主對角線）：沿每條對角線 **升序排序**  
- **左下三角**（包含主對角線）：沿每條對角線 **降序排序**

---

### 範例：
**Input:** grid = [[3, 3, 1], [2, 2, 1],[1, 1, 1]]

**Output:** [[3, 1, 1],[2, 2, 1],[1, 3, 1]]


---

## 解法概念

### 方法 1：使用 Heap (優先佇列)
1. 針對右上三角 (`col = 1 ~ n-1`)，沿著每條對角線收集元素放進 `min-heap`。
2. 依序從 `min-heap` 取出，寫回矩陣。
3. 針對左下三角 (`row = 0 ~ n-1`)，沿著每條對角線收集元素，推入 `max-heap`（存負值）。
4. 依序從 `max-heap` 取出，翻回正值，寫回矩陣。

> Python heapq 都是最小堆，關於最大堆的部分，可以用負數塞入去排序，取出再轉回正數
