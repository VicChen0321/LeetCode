# 53. Maximum Subarray

**LeetCode Link:** [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)  
**Difficulty:** Medium  
**Tags:** Array, Divide and Conquer, Dynamic Programming

---

## 題目描述
給定一個整數陣列 `nums`，請找出一個 **連續子陣列**（至少包含一個元素），其總和最大，並回傳該最大總和。

---

## 範例
- Input: `nums = [-2,1,-3,4,-1,2,1,-5,4]`  
  Output: `6`  
  解釋：最大子陣列為 `[4,-1,2,1]`，總和為 6。

- Input: `nums = [1]`  
  Output: `1`

- Input: `nums = [5,4,-1,7,8]`  
  Output: `23`

---

## 解法概念

### 方法：Kadane’s Algorithm（動態規劃）
1. 設置兩個變數：
   - `curSum`：當前子陣列的最大和  
   - `maxSum`：全局最大和  
2. 遍歷每個元素 `num`：
   - 更新 `curSum = max(num, curSum + num)`  
     （選擇繼續累加或重新開始一個子陣列）  
   - 更新 `maxSum = max(maxSum, curSum)`  
3. 遍歷完成後，`maxSum` 即為最大子陣列和。

---

## 時間與空間複雜度
- **時間複雜度：** O(n)，僅需一次遍歷  
- **空間複雜度：** O(1)，只需常數額外空間  

---

## 關鍵重點
- Kadane’s Algorithm 是這題的經典最佳解。  
- 每一步都決定「要不要把當前數字接在前一段的子陣列後面」。  
- 動態規劃核心公式：  
  `dp[i] = max(nums[i], dp[i-1] + nums[i])`