# 812. Largest Triangle Area

**LeetCode Link:** [812. Largest Triangle Area](https://leetcode.com/problems/largest-triangle-area/)
**Difficulty:** Easy
**Tags:** Geometry, Math

---

## 題目描述

給定一組 2D 平面上的點，請找出由其中任意三個點組成的三角形的最大面積。

---

## 範例

* Input: `points = [[0,0],[0,1],[1,0],[0,2],[2,0]]`
  Output: `2.0`

---

## 解法概念

### 方法：枚舉三點 + 測量員公式（鞋帶公式）

1. 三角形面積公式（Shoelace formula / 向量叉積公式）：

   ```
   area = 0.5 * |x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2)|
   ```
2. 枚舉所有三點組合，計算面積。
3. 保留最大值。

---

## 時間與空間複雜度

* **時間複雜度：** O(n³)，枚舉所有三點組合。
* **空間複雜度：** O(1)，只需常數空間。

---

## 關鍵重點

* 注意三角形面積公式的應用。
* 題目點數 n ≤ 50，O(n³) 可接受。
