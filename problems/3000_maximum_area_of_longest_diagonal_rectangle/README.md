# 3000 Maximum Area of Longest Diagonal Rectangle

**LeetCode Link:** [3000. Maximum Area of Longest Diagonal Rectangle](https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/)  
**Difficulty:** Easy
**Tags:** Array

---

## 題目描述
給定一組矩形（矩形由其長、寬組成），找出對角線最長的矩形。若有多個矩形的對角線長度相同，則從這些矩形中選擇面積最大的矩形，並回傳該矩形的面積。

- 範例：
  - Input: dimensions = [[9,3],[8,6]] -> Output: 48

Constraints:
- 1 <= dimensions.length <= 100
- dimensions[i].length == 2
- 1 <= dimensions[i][0], dimensions[i][1] <= 100

---

## 解法概念

### 方法：單次遍歷找最大對角線與面積
1. 對於每個矩形，計算其對角線長度的平方（`wi² + hi²`）。
2. 如果當前矩形的對角線平方大於目前已知最大值，更新最大對角線平方及對應的面積。
3. 如果相等，選面積更大的那個。
4. 遍歷結束後回傳紀錄的最大面積。

- **時間複雜度**：O(n)，n 為矩形數量，每個檢查一次。
- **空間複雜度**：O(1)，只使用常數額外空間。