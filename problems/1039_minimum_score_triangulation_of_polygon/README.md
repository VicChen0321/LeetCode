# 1039. Minimum Score Triangulation of Polygon

**LeetCode Link:** [1039. Minimum Score Triangulation of Polygon](https://leetcode.com/problems/minimum-score-triangulation-of-polygon/)  
**Difficulty:** Medium  
**Tags:** Dynamic Programming

---

## 題目描述
給定一個凸多邊形，頂點編號為 `0 ... n-1`，每個頂點對應一個權重 `values[i]`。  

將多邊形劃分為 **三角形集合**（三角剖分），每個三角形 `(i, j, k)` 的分數是 `values[i] * values[j] * values[k]`。  
**總分數 = 所有三角形分數的總和**。  

請你找出 **最小的總分數**。

---

## 範例
- Input: `values = [1,2,3]`  
  Output: `6`  
  解釋：只有一個三角形 (1*2*3 = 6)

- Input: `values = [3,7,4,5]`  
  Output: `144`  
  解釋：最佳劃分為 (3,4,5) + (3,7,5) = 60 + 84 = 144

- Input: `values = [1,3,1,4,1,5]`  
  Output: `13`

---

## 解法概念

### 方法：區間 DP（Interval DP）
1. **定義狀態**  
   設 `dp[i][j]` 為從節點 `i` 到節點 `j`（順時針方向）的最小劃分總分。  

2. **轉移方程** 
   ```
   dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[k] * values[j])
   ```
其中 `i < k < j`。  

3. **初始化**  
- `dp[i][i+1] = 0`（兩個點無法形成三角形）  
- `dp[i][i+2] = values[i]*values[i+1]*values[i+2]`（三個點形成唯一三角形）

4. **最終答案**  
`dp[0][n-1]` 即整個多邊形的最小劃分分數。

---

## 時間與空間複雜度
- **時間複雜度：** O(n³)，三層迴圈（i, j, k）。  
- **空間複雜度：** O(n²)，DP 表大小。  

---

## 關鍵重點
- 區間 DP 的典型應用，與「戳氣球（312）」和「矩陣鏈乘」非常相似。  
- 凸多邊形性質保證三角剖分一定合法。  
- 枚舉中間點 `k` 嘗試所有劃分，取最小值。  