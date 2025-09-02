# 3025 Find the Number of Ways to Place People I

**LeetCode Link:** [3025. Find the Number of Ways to Place People I](https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/)  
**Difficulty:** Medium  
**Tags:** Geometry, Array, Sorting, Enumeration

---

## 題目描述
你有一個 `n x 2` 的陣列 `points`，每個元素 `points[i] = [xi, yi]` 表示平面上的一個點。  

你要從中挑選兩個人：  
- Alice 站在 **左上角** `(x1, y1)`  
- Bob 站在 **右下角** `(x2, y2)`  

形成一個由 `(x1, y1)` 和 `(x2, y2)` 定義的 **矩形邊界**（矩形的邊界和內部都包含在內）。  

條件：
- 矩形邊界內 **不能有其他任何人**。

返回所有合法配對 `(Alice, Bob)` 的數量。


---

## 解法概念

### 方法：排序 + 枚舉 + 剪枝
1. **排序**  
   - 先按 x 座標升序  
   - x 相同時按 y 座標降序

2. **枚舉每個點作為左上角 (Alice)**  
   - 向右枚舉候選右下角 (Bob)
   - 維護 `maxY`，表示矩形內最高的 y
   - 如果該候選點的 y 不高於左上角，且比當前 `maxY` 高，代表矩形內沒有第三人，可以記錄一個合法組合。

---

## 時間與空間複雜度
- **時間複雜度:** O(n²)  
  n 最多 50，雙層枚舉可接受
- **空間複雜度:** O(log n)  
  排序時所需的輔助空間

---

## 關鍵重點
- 按 **x 升序 + y 降序** 排序，方便確定左上與右下的座標方向  
- 用 `maxY` 剪枝，確保矩形內不會有第三個人  
- 複雜度足夠輕量，直接暴力枚舉即可