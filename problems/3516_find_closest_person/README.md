# 3516 Find Closest Person

**LeetCode Link:** [3516. Find Closest Person](https://leetcode.com/problems/find-closest-person/)  
**Difficulty:** Easy  
**Tags:** Math, Simulation

---

## 題目描述
給定三個整數：`x, y, z`，分別表示數線上三個人的位置：  
- `x` 是 Person 1 的位置  
- `y` 是 Person 2 的位置  
- `z` 是 Person 3 的位置（目標）

Person 1 和 Person 2 同時以相同速度向 Person 3（`z`）移動。請判斷誰先到達：

- 若 Person 1 比 Person 2 先到達，返回 `1`  
- 若 Person 2 比 Person 1 先到達，返回 `2`  
- 若兩人同時到達，返回 `0`

---

## 解法概念

### Method: 模擬 & 絕對值比較
- 分別計算 Person 1 與 Person 3 的距離：`abs(x - z)`  
- 計算 Person 2 與 Person 3 的距離：`abs(y - z)`  
- 比較兩個距離：
  - 相等 → 回傳 `0`  
  - Person 1 小 → 回傳 `1`  
  - Person 2 小 → 回傳 `2`

## 時間與空間複雜度
- **時間複雜度：** O(1) — 僅做固定次數的運算  
- **空間複雜度：** O(1) — 無額外儲存

---

## 核心重點
1. 認清題意：兩人以相同速度移動到同一目標，只比較距離即可。
2. 注意 `abs()` 使用，確保方向無論如何都正確比較。
3. 三種情況：小於、等於、大於，一定要覆蓋。