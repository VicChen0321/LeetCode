# 1518. Water Bottles

**LeetCode Link:** [1518. Water Bottles](https://leetcode.com/problems/water-bottles/)  
**Difficulty:** Easy  
**Tags:** Simulation, Math

---

## 題目描述

你有 `numBottles` 瓶水，每喝完一瓶，你會得到一個空瓶子。  
當你擁有的空瓶數量達到 `numExchange` 時，可以把這些空瓶換成 **1 瓶新的水**。  

請計算你最多可以喝到幾瓶水。  

---

## 範例

- Input: `numBottles = 9, numExchange = 3` → Output: `13`  
  解釋：喝 9 瓶 → 9 個空瓶 → 換 3 瓶 → 共 12；再喝 3 瓶 → 3 個空瓶 → 換 1 瓶 → 共 13。

- Input: `numBottles = 15, numExchange = 4` → Output: `19`  

---

## 解法概念

### 方法：模擬交換過程
1. 初始化 `drank = numBottles`，代表已喝水數量。  
2. 記錄當前空瓶數 `empty = numBottles`。  
3. 當 `empty >= numExchange`：
   - 換得新瓶數 `newBottles = empty // numExchange`
   - 更新 `drank += newBottles`
   - 更新空瓶數 `empty = empty % numExchange + newBottles`  
4. 迴圈結束後，`drank` 即為最大可喝水數。  

---

## 時間與空間複雜度

- **時間複雜度：** O(log n)，因為每次交換後瓶數會縮減。  
- **空間複雜度：** O(1)。  

---

## 關鍵重點
- 這題就是模擬換瓶子，不要漏算最後換到的瓶子。  
- `空瓶 = 剩下未換掉的 + 剛換到的新瓶喝完後留下的`。  