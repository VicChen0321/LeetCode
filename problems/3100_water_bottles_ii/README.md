# 3100. Water Bottles II

**LeetCode Link:** [3100. Water Bottles II](https://leetcode.com/problems/water-bottles-ii/)  
**Difficulty:** Medium  
**Tags:** Simulation, Math

---

## 題目描述

你最初有 `numBottles` 瓶滿的水。  
操作規則：  
- 你可以喝掉任意數量的滿瓶，使它們成為空瓶。  
- 如果你有 **至少 `numExchange` 個空瓶**，可以用這些空瓶換成 **1 瓶滿水**，換完後 **`numExchange` 增加 1**。  
- 注意：**不能**用同一批空瓶做多重兌換（一次只能兌換 `numExchange` 個空瓶換一瓶滿水）。  

問：你最多能喝到多少瓶水。

---

## 解法概念

### 方法：模擬 + 數學簡化

1. **初始化**  
   設 `ans = numBottles`（先喝掉所有最初的滿瓶）。  

2. **交換與喝的迴圈**  
   當剩餘空瓶數 ≥ `numExchange` 時，做以下操作：
   - 用 `numExchange` 空瓶換 1 瓶滿水 → 實際上空瓶數減 `numExchange`、但喝掉新瓶又得到 1 空瓶 ⇒ net 空瓶數變為 `numBottles - numExchange + 1`  
   - `numExchange` 自增 1  
   - `ans` 加 1（喝掉從兌換得到的那瓶水）  
   - 把新的空瓶數視為新的 `numBottles`（或把空瓶數記在一個變數裡，與滿瓶／空瓶合併考量）

3. **結束條件**  
   當空瓶數 < `numExchange`，無法再兌換，停止。

---

## 時間與空間複雜度

- **時間複雜度：** O(numBottles / numExchange)（每次迴圈消耗 `numExchange - 1` 個空瓶） 
- **空間複雜ity：** O(1)，只用常數大小額外變數