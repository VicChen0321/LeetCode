# 1 Two Sum

**LeetCode Link:** [1. Two Sum](https://leetcode.com/problems/two-sum/)  
**Difficulty:** Easy  
**Tags:** Array, Hash Table

---

## 題目描述
給定一個整數陣列 `nums` 和一個整數 `target`，請找出 **兩個不同位置** 的數字，讓它們的和等於 `target`，並回傳它們的索引值。

### 範例：
- Input: `nums = [2,7,11,15], target = 9`  
  Output: `[0,1]`  
  Explanation: `nums[0] + nums[1] = 2 + 7 = 9`

- Input: `nums = [3,2,4], target = 6`  
  Output: `[1,2]`

- Input: `nums = [3,3], target = 6`  
  Output: `[0,1]`

Constraints:
- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- **只有一個有效答案**

---

## 解法概念

### 方法 1：暴力解法 (Brute Force)
1. 使用雙層迴圈檢查每一對數字是否符合條件。
2. 時間複雜度為 **O(n²)**，不適合大數據。

### 方法 2：Hash Map (最佳解)
1. 建立一個字典，儲存 數值 → 索引 的對應關係。
2. 遍歷陣列，檢查 target - nums[i] 是否已存在於字典中：
   - 存在 → 找到答案，回傳索引
   - 不存在 → 將當前數值和索引放入字典
3. 時間複雜度 **O(n)**，空間複雜度 **O(n)**。