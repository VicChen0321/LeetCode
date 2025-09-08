# 1317 Convert Integer to the Sum of Two No-Zero Integers

**LeetCode Link:** [1317. Convert Integer to the Sum of Two No-Zero Integers](https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/)  
**Difficulty:** Easy  
**Tags:** Math, Greedy

---

## 題目描述
給定一個整數 `n`，請找出兩個正整數 `A` 和 `B`，滿足：
- `A + B = n`
- `A` 和 `B` **都不包含數字 0**

返回任意一組合法答案即可。

### 範例
- Input: `n = 2` → Output: `[1,1]`  
- Input: `n = 11` → Output: `[2,9]` 或 `[9,2]`  
- Input: `n = 100` → Output: `[1,99]`、`[99,1]` 等

---

## 解法概念

### 方法：暴力檢查
1. 從 `i = 1` 到 `n-1` 枚舉  
2. 檢查 `i` 和 `n-i` 是否 **都不包含 0**  
3. 找到第一組滿足條件的即返回

**檢查方法**：
- 將數字轉成字串，判斷是否包含 `'0'`
- 或者用數學方法逐位檢查是否有 0

---

## 時間與空間複雜度
- **時間複雜度:** O(n * log n)  
  - n 是數字大小，log n 是檢查每個數字位數的成本
- **空間複雜度:** O(1)  

---

## 關鍵重點
- 題目保證一定有解  
- 枚舉 + 判斷是最簡單且可接受的方法  
- 不需要特別優化，n ≤ 10⁴ 時暴力可行

