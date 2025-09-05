# 2749 Minimum Operations to Make the Integer Zero

**LeetCode Link:** [2749. Minimum Operations to Make the Integer Zero](https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero/)  
**Difficulty:** Medium  
**Tags:** Math, Bit Manipulation, Enumeration

---

## 題目描述
給定兩個整數 `num1` 和 `num2`。每次操作可選一個 `i`（範圍 `[0, 60]`），從 `num1` 中**減去** `2^i + num2`。  
請找出最少多少次操作能讓 `num1` 恰好變成 0。如果不可能，返回 `-1`。  


---

## 解法概念

###  核心思路：
1. 假設要做 `k` 次操作，則：`num1 = k * num2 + (2^a1 + 2^a2 + ... + 2^ak)`
→ 代表 `num1` 可以拆成 k 個 `num2` 的冪次和。

2. 等價轉換：  
設 `X = num1 - k * num2`，檢查是否能拆分成 k 個 `num2` 的倍數。
- **必要條件 1**：`X >= 0`（否則超扣了）。
- **必要條件 2**：`popcount(X) <= k`（因為至少要有那麼多次操作，才能 cover 掉二進位中的 1）。
- **必要條件 3**：`k <= X`（次數不能比數字還大，否則拆不出來）。

3. 策略：從 `k = 1` 開始枚舉，找到第一個滿足條件的 `k` 就是答案。  
若找不到，回傳 `-1`。

---

## 枚舉策略
從 `k = 0` 開始，到最大值（60），逐一檢查上述條件是否成立，找到最小滿足者即為答案。有些情況當 `x < 0` 時，後面只會更小，可直接跳出。

## 時間與空間複雜度

- **時間複雜度：O(1)** — 枚舉上限固定為 61 次，再做位計數都是常數時間。
- **空間複雜度：O(1)** — 僅使用少量變數，沒有額外資料結構。

---

## 核心關鍵
- 轉化目標為「是否能用 k 個 2 的冪次表示 x = num1 - k*num2」
- bit_count(x) 為最少個數，x 為最多個數
- 枚舉 k 並找到第一個滿足條件者