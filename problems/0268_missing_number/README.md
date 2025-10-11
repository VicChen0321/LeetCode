好的，以下是**LeetCode 268. Missing Number** 按照你指定的格式整理：

***

# 268 Missing Number

**LeetCode Link:** [268. Missing Number](https://leetcode.com/problems/missing-number/)  
**Difficulty:** Easy  
**Tags:** Array, Math, Bit Manipulation

***

## 題目描述

給定一個包含 `n` 個不同數字的陣列 `nums`，每個數都是在 `0 ~ n` 之間（共 n+1 個可能），其中**正好有一個數字缺失**。請找出這個缺失的數字。

- 陣列長度為 `n`，元素範圍皆在 `0 ~ n` 之間且不重複。
- 需返回那個**沒出現**的數字。

### 範例

- Input: `nums = [3][0][1]`  
  Output: `2`  
  解釋：陣列有 ，少了 `2`
- Input: `nums = [0][1]`  
  Output: `2`  
  解釋：只有 ，缺失 `2`
- Input: `nums = [9][6][4][2][3][5][7]`
  Output: `8`

---

## 解法概念

### 方法一：公式求和

- 計算 `0~n` 的總和 (sum1)
  - 計算總和可以用梯形公式求
- 計算陣列 `nums` 所有元素的總和 (sum2)
- 答案就是 `sum1 - sum2`

#### 實作步驟

1. 設 `n = nums.length`
2. 計算理論總和：`sum1 = n*(n+1)/2`
3. 計算陣列實際總和：`sum2 = sum(nums[i] for i in range(n))`
4. 回傳 `sum1 - sum2`

### 方法二：XOR 位元運算

- 把`0~n`和陣列所有元素各自 XOR起來，剩下的就是缺失的數字。

#### 實作步驟

1. 設 result = n
2. 遍歷 i = 0~n-1，讓 result ^= i ^ nums[i]
3. 回傳 result（即缺失的數字）

---

## 時間與空間複雜度

- **時間複雜度：** O(n)  
  - 需要掃描一次陣列。
- **空間複雜度：** O(1)  
  - 只需常數變數計算總和、或進行 XOR 運算。