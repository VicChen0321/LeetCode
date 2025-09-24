# 166. Fraction to Recurring Decimal

**LeetCode Link:** [166. Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/)  
**Difficulty:** Medium  
**Tags:** Hash Table, Math

---

## 題目描述
給定兩個整數 `numerator` 和 `denominator`，返回它們相除後的 **字串表示**。  

- 如果結果是一個整數，直接輸出整數字串。  
- 如果是小數，則輸出小數部分。  
- 如果小數部分會 **循環重複**，將重複部分用括號括起來。  

---

## 範例
- Input: `numerator = 1, denominator = 2` → Output: `"0.5"`  
- Input: `numerator = 2, denominator = 1` → Output: `"2"`  
- Input: `numerator = 2, denominator = 3` → Output: `"0.(6)"`  
- Input: `numerator = 4, denominator = 333` → Output: `"0.(012)"`  

---

## 解法概念

### 方法：模擬長除法 + Hash Map
1. 先處理 **正負號**，取絕對值運算，最後再加回符號。  
2. 計算整數部分 `integer = numerator // denominator`。  
3. 計算餘數 `remainder = numerator % denominator`：  
   - 如果為 `0`，代表可以整除，直接回傳結果。  
4. 否則進入小數部分：  
   - 用字典 `map<remainder, index>` 紀錄每個餘數出現的位置。  
   - 每次將餘數乘以 `10`，再取商作為下一位小數。  
   - 若餘數重複，代表開始循環 → 在對應位置加括號。  

---

## 時間與空間複雜度
- **時間複雜度：** O(n)，n 為循環節長度（不超過 `denominator`）。  
- **空間複雜度：** O(n)，儲存餘數出現的位置。  

---

## 關鍵重點
- 使用 HashMap 追蹤 **餘數** 是否重複  
- 小心處理負號與整數部分  
- 餘數變 `0` → 結束  