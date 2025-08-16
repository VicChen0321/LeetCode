# 0342 Power of Four

**LeetCode Link:** [342. Power of Four](https://leetcode.com/problems/power-of-four/)
**Difficulty:** Easy  
**Tags:** Math, Bit Manipulation, Recursion

## 題目描述
判斷一個整數 `n` 是否是 4 的冪次方（`4^k`，k ≥ 0）。

- 範例：
  - Input: `16` → Output: `true`
  - Input: `5` → Output: `false`
  - Input: `1` → Output: `true`

---

## 解法概念

### 方法 1：迴圈除法
- 核心思路：不斷除以 4，如果最終能整除到 1，則為 4 的冪次方。
- 時間複雜度：O(log₄ n)
- 空間複雜度：O(1)


### 方法 2：位元運算判斷
- 先判斷 n 是否為 2 的冪次方：
  - n > 0 && (n & (n - 1)) == 0
  - 如果是 2 的冪次方，二進制就只會有一個 1
- 確保 1 的位元在偶數位（0x55555555 = 01010101...二進位）
  - n & 0x55555555 != 0
> 這部分可以 AND 0x55555555 或者 count (n - 1) bit 計算是不是奇數個，就能得知是不是在偶數位
- 時間複雜度：O(1)
- 空間複雜度：O(1)