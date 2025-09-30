# 2221. Find Triangular Sum of an Array

**LeetCode Link:** [2221. Find Triangular Sum of an Array](https://leetcode.com/problems/find-triangular-sum-of-an-array/)
**Difficulty:** Medium
**Tags:** Array, Math, Simulation

---

## 題目描述

給定一個整數陣列 `nums`，不斷將相鄰兩個數字相加並對 10 取模，產生新的陣列。
重複進行直到陣列中只剩下一個數字，該數字即為 **Triangular Sum**。

---

## 範例

* Input: `nums = [1,2,3,4,5]`
  Output: `8`

**過程：**

```
[1,2,3,4,5] → [3,5,7,9] → [8,2,6] → [0,8] → [8]
```

---

## 解法概念

### 方法一：模擬

1. 不斷迭代陣列，將 `nums[i] = (nums[i] + nums[i+1]) % 10`。
2. 每一輪陣列長度縮減 1。
3. 最後 `nums[0]` 即為答案。

### 方法二：數學組合數公式 (最佳化)

利用 Pascal’s Triangle 性質，最終答案等於：

```
sum(nums[i] * C(n-1, i)) % 10
```

其中 `C(n-1, i)` 為組合數，n 為陣列長度。

---

## 時間與空間複雜度

* **模擬法**

  * 時間複雜度：O(n²)
  * 空間複雜度：O(1)

* **數學法**

  * 時間複雜度：O(n log n)（組合數運算）
  * 空間複雜度：O(1)

## 關鍵重點

* 模擬法簡單直接，適合題目限制 (n ≤ 1000)。
* 數學法能展現更深的理解，本質是 **Pascal’s Triangle mod 10** 的應用。