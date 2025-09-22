# 3005. Count Elements With Maximum Frequency

**LeetCode Link:** [3005. Count Elements With Maximum Frequency](https://leetcode.com/problems/count-elements-with-maximum-frequency/)  
**Difficulty:** Easy  
**Tags:** Hash Table, Array, Counting

---

## 題目描述
給定一個整數陣列 `nums`，我們要找出出現 **最多次的數字們**，並回傳這些數字在陣列中出現的總次數。  

---

## 範例

**範例 1:**

```
輸入: nums = [1,2,2,3,1,4]
輸出: 4
解釋:
數字 1 與 2 都出現了 2 次（最大頻率）。
總出現次數 = 2 + 2 = 4。
```

**範例 2:**

```
輸入: nums = [1,2,3,4,5]
輸出: 1
解釋:
所有數字都只出現一次，最大頻率 = 1。
總出現次數 = 1。
```

---

## 解法概念

### 方法：HashMap 統計頻率
1. 遍歷陣列 `nums`，使用 HashMap 統計每個數字出現次數。  
2. 找出最大頻率 `maxFreq`。  
3. 遍歷所有數字的頻率，將頻率等於 `maxFreq` 的數字次數加總。  

---

## 時間與空間複雜度
- **時間複雜度:** O(n)  
  單次遍歷計數 + 找最大值  
- **空間複雜度:** O(n)  
  用於存放頻率表

---

## 關鍵重點
- 本質是 **頻率計數問題**。  
- 需要同時計算「最大頻率」與「所有等於最大頻率的數字出現次數總和」。  
- 若所有數字都只出現一次，答案就是 `1`。
