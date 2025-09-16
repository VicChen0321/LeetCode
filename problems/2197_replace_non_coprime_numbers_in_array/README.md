# 2197 Replace Non-Coprime Numbers in Array

**LeetCode Link:** [2197. Replace Non-Coprime Numbers in Array](https://leetcode.com/problems/replace-non-coprime-numbers-in-array/)  
**Difficulty:** Hard  
**Tags:** Array, Stack, Number Theory, GCD

---

## 題目描述
給定一個整數陣列 `nums`。反覆執行以下操作直到無法再做：

1. 找任意一對 **相鄰** 的數字 `(x, y)`，使它們不是互質（**non-coprime**），也就是 `GCD(x, y) > 1`。  
2. 如果找不到這樣的相鄰對，就停止。  
3. 否則，把這兩個數字刪除，並將它們替換成它們的最小公倍數（LCM）。  
4. 接著繼續這個過程。

保證無論以什麼順序合併相鄰非互質對，最終結果陣列是唯一的。  
最終陣列中的值 ≤ 10⁸。

### 範例
- Input: `nums = [6,4,3,2,7,6,2]` → Output: `[12, 7, 6]`  
  解釋流程：  
  `6,4` → LCM = 12 → `[12,3,2,7,6,2]`  
  `12,3` → LCM = 12 → `[12,2,7,6,2]`  
  `12,2` → LCM = 12 → `[12,7,6,2]`  
  `6,2` → LCM = 6 → `[12,7,6]`

- Input: `nums = [2,2,1,1,3,3,3]` → Output: `[2,1,1,3]`

---

## 解法概念

### 方法：Stack + 數論（GCD / LCM）
- 用 Stack（或類似動態陣列，如 `ans` list）來維護當前處理好的數字。  
- 遍歷 `nums` 的每個元素 `x`：
  1. 將 `x` 推入 Stack。  
  2. 當 Stack 最後兩個元素是非互質的（`GCD(top−1, top) > 1`），就把這兩個元素合併成一個 `LCM`，然後 pop 最後一個，並把前一個替換成這個 LCM。  
  3. 因為新的 LCM 可能又與 Stack 中前一個元素非互質，所以要用 while loop 持續檢查直到不能合併為止。  

---

## 時間與空間複雜度
- **時間複雜度：** O(n · log M)  
  - n = `nums.length`  
  - M = 最大值或中間出現的數字大約 ≤ 10⁸  
  - 每個元素會被 push 一次，可能被多次合併，但總合併次數是 amortized O(n)；GCD 計算費用是 O(log M)

- **空間複雜度：** O(n)  
  - Stack 在最壞情況下會儲存所有未合併元素