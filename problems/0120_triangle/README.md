# 120. Triangle

**LeetCode Link:** [120. Triangle](https://leetcode.com/problems/triangle/)  
**Difficulty:** Medium  
**Tags:** Array, Dynamic Programming

---

## 題目描述
給定一個「三角形」結構的整數陣列 `triangle`，從最上方走到最下方，每一步只能走到下一層相鄰的數字。  
請回傳 **最小路徑和**。

---

## 範例
- Input: `triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]`  
  Output: `11`  
  解釋：最小路徑為 `2 → 3 → 5 → 1 = 11`

- Input: `triangle = [[-10]]`  
  Output: `-10`  

---

## 解法概念

### 方法：自底向上動態規劃
1. 從倒數第二層開始，逐層往上更新。  
2. 每個元素 `triangle[i][j]` 更新為：`triangle[i][j] = triangle[i][j] + min(triangle[i+1][j], triangle[i+1][j+1])` 
3. 最後 `triangle[0][0]` 就是最小路徑和。  

這樣做可以避免額外空間，直接在原陣列上更新。
> 也可以使用一個 `dp[n]` 去記錄

---

## 時間與空間複雜度
- **時間複雜度：** O(n²)，n 是三角形高度（總元素數量 ≈ n²/2）。  
- **空間複雜度：** O(1)，在原地更新。  

---

## 關鍵重點
- 最小路徑問題 → 從 **底部開始推導**  
- 只需要考慮下一層相鄰兩個數字  
- 最後答案就是頂端元素  