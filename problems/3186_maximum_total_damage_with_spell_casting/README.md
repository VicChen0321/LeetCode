# 3186 Maximum Total Damage With Spell Casting

**LeetCode Link:** [3186. Maximum Total Damage With Spell Casting](https://leetcode.com/problems/maximum-total-damage-with-spell-casting/)  
**Difficulty:** Medium  
**Tags:** Array, Hash Table, Two Pointers, Binary Search, Dynamic Programming, Sorting, Counting

---

## 題目描述

一位魔法師有各種法術。  
給你一個陣列 `power`，每個元素代表一個法術的傷害值。*同一傷害值的法術可以有多個*。

已知規則如下：

- 若魔法師施放傷害為 `power[i]` 的法術，則**不能施放傷害為 `power[i] - 2`、`power[i] - 1`、`power[i] + 1`、`power[i] + 2` 的法術**
- 每個法術僅能施放一次

請你回傳**魔法師可造成的最大總傷害值**。

### 範例

- Input: `power = [1][1][3][4]`
  - Output: `6`
  - 解釋：施放兩個傷害 1 和一個傷害 4，共 1+1+4=6

- Input: `power = [7][1][6][6]`
  - Output: `13`
  - 解釋：施放傷害 1、6、6，共 1+6+6=13

---

## 解法概念

這題本質上類似「刪除並賺分」(Delete and Earn)問題，但禁止區間是 ±2，所以需要進一步考慮。

### 方法一：計數 + 動態規劃 (DP)

- 先計算每個傷害值的數量及其總分
- 針對傷害值排序後用動態規劃：  
  - 設 `dp[x]` 表最大得分，依序考慮每種傷害值 x  
  - 若取 `x` 則必須略過 `x-2`、`x-1`、`x+1`、`x+2`
  - 狀態轉移：  
    - 選/不選（如同帶有冷卻區間的打家劫舍）

#### 實作步驟

1. 用 HashMap 統計所有不同傷害值的次數（累加總傷害）
2. 把所有不同傷害值從小到大排序
3. 設一個 DP 陣列 `dp[i]` 表考慮前 i 個不同傷害值的最大傷害
4. 逐個決策：  
   - 不選當前傷害值，繼承 `dp[i-1]`
   - 選當前傷害值，累加其總分+`dp[k]`，其中 k 是最後一個可選的不衝突傷害值（比現在小3或更小的位置）
5. 回傳 dp 最後一項

---

## 時間與空間複雜度

- **時間複雜度：** O(n log n)  
  - n 為陣列長度，排序與 DP 都有類似的複雜度  
- **空間複雜度：** O(n)  
  - 需要用來計數及動態規劃儲存
