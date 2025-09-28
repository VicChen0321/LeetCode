# 976. Largest Perimeter Triangle

**LeetCode Link:** [976. Largest Perimeter Triangle](https://leetcode.com/problems/largest-perimeter-triangle/)
**Difficulty:** Easy
**Tags:** Array, Greedy, Sorting

---

## 題目描述

給定一個整數陣列 `nums`，代表三角形的邊長，請找出可以組成**非退化三角形**的最大周長。
若無法組成三角形，則回傳 `0`。

**非退化三角形條件：**
三邊長 `a, b, c` (a ≤ b ≤ c) 必須滿足

```
a + b > c
```

---

## 範例

* Input: `nums = [2,1,2]` → Output: `5`
* Input: `nums = [1,2,1,10]` → Output: `0`

---

## 解法概念

### 方法：排序 + 貪心

1. 將陣列從大到小排序。
2. 從最大的邊長往下檢查三個相鄰的數字是否能構成三角形 (`a + b > c`)。
3. 第一個符合的組合即為最大周長。
4. 若無符合則回傳 `0`。

---

## 時間與空間複雜度

* **時間複雜度：** O(n log n)，排序花費。
* **空間複雜度：** O(1)，只需常數額外空間。

---

## 關鍵重點

* 非退化三角形條件要正確套用。
* 從大邊開始檢查可保證最大周長。