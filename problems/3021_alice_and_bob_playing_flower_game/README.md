# 3021 Alice and Bob Playing Flower Game

**LeetCode Link:** [3021. Alice and Bob Playing Flower Game](https://leetcode.com/problems/alice-and-bob-playing-flower-game/)  
**Difficulty:** Medium  
**Tags:** Math, Game Theory, Counting, Parity

---

## 題目描述
Alice 和 Bob 在一個圓形花園進行遊戲。從 Alice 的位置開始，順時針方向有 `x` 朵花、逆時針方向有 `y` 朵花。

遊戲規則：
1. Alice 先開始，雙方輪流摘花，每次只能摘一朵，可從順時針或逆時針方向摘。
2. 摘完最後一朵花的人，會贏得遊戲。

請計算在所有 `(x, y)` 組合中，Alice 能保證勝利的起始方式有多少種。條件：
- `1 ≤ x ≤ n`
- `1 ≤ y ≤ m`

---

## 解法概念

Alice 贏的條件是最後摘花在她這邊，也就是遊戲總步數為奇數。因為每回合摘一朵花，總共摘了 `x + y` 步：

- 如果 `x + y` 是奇數 → Alice 最後一步摘，所以她贏。
- 如果 `x + y` 是偶數 → Bob 最後一步，Alice 輸。

因此，我們只要計算 `(x, y)` 中使得 `x + y` 為奇數的組合數：

1. **x 是奇數，y 是偶數**  
2. **x 是偶數，y 是奇數**

---

## 方法一：數學

- `xOdd = (n + 1) // 2` → x 是奇數的數量  
- `xEven = n // 2` → x 是偶數的數量  
- 同理：  
  - `yOdd = (m + 1) // 2`  
  - `yEven = m // 2`

Alice 能贏的組合數為：`xOdd * yEven + xEven * yOdd`

---

## 時間與空間複雜度
- **時間複雜度：** O(1) — 只做幾次整數運算  
- **空間複雜度：** O(1) — 只使用固定數量的變數，不隨輸入成長
