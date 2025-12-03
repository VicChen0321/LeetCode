# 3623 Count Number of Trapezoids I

**LeetCode Link:** [3623. Count Number of Trapezoids I](https://leetcode.com/problems/count-number-of-trapezoids-i/)  
**Difficulty:** Medium  (來自 weekly/contest 題目) :contentReference[oaicite:1]{index=1}  
**Tags:** Geometry, Combinatorics, Hash Table / Grouping  

---

## 題目描述

給定一個二維整數陣列 `points`，其中每個 `points[i] = [x_i, y_i]` 表示平面上一個點。你需要從中選出任意四個不同點，計算總共有多少種方式能構成一個 **水平梯形**（horizontal trapezoid）。

- 「水平梯形」定義為：這四個點能組成一個凸四邊形，且至少有一對邊是水平方向的（也就是兩條邊與 x-軸平行，也就是兩條邊的 y 值相同）。 :contentReference[oaicite:2]{index=2}  
- 要返回所有不同的梯形數量，並對 `10^9 + 7` 取模。 :contentReference[oaicite:3]{index=3}  

### 範例

- Input: `points = [[1,0],[2,0],[3,0],[2,2],[3,2]]` → Output: `3`  
  解釋 — 可構成 3 個不同水平梯形。 :contentReference[oaicite:4]{index=4}  
- Input: `points = [[0,0],[1,0],[0,1],[2,1]]` → Output: `1` :contentReference[oaicite:5]{index=5}

---

## 解法概念

### 方法：按 y-座標分組 + Combinatorics + 累積計算  

1. 首先把所有點按照其 y 座標分組 —— 統計每個 y 值有多少個點。這代表在該 y 水平線上可形成多少條「水平邊」。  
2. 若某個 y 水平線上有 `c` 個點，則這一水平線上任選 2 點可以構成一條水平邊，有 `C(c, 2) = c * (c−1) / 2` 種選法。  
3. 因為梯形需要兩條平行且水平方向的邊（頂邊 + 底邊），你可以選擇任意兩個不同 y 值（即不同高度的水平線），在每條水平線上各選一條水平邊 → 這會構成一個水平梯形（只要 4 點都不重複即可 — 因為 y 不同保證不共點）  
4. 所以整體流程大致：
   - 對每個 distinct y 值，算出 `comb[y] = C(count[y], 2)`（該水平線能形成多少條水平邊）  
   - 把這些 `comb[y]` 排成一個 list（或 map over y）  
   - 對這些線（y）兩兩配對：對於任意 y_i 和 y_j（i < j），可組成 `comb[y_i] * comb[y_j]` 個梯形  
   - 為了有效率，可以先把所有 `comb[y]` 加總 /累積，再對每個 y 當作「上（或下）邊」時，乘以「累積過的其他水平邊數量」  

5. 最後對結果 mod `10^9 + 7`。  

> 關鍵：因為只要水平方向邊 — 不用考慮 x-順序／凸性複雜幾何檢查 — 分組 + 組合數學即可。  

---

## 時間與空間複雜度

- **時間複雜度**：O(n + U)  
  - n = `points.length`（遍歷所有點分組 + 統計）  
  - U = number of distinct y-values（遍歷組合 + 計算組合數 + 累積 + 最後計算）  
- **空間複雜度**：O(U)  
  - 需要一張 map / hash table 儲存 y → count  
