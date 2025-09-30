# 11. Container With Most Water

**LeetCode Link:** [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
**Difficulty:** Medium
**Tags:** Array, Two Pointers, Greedy

---

## 題目描述

給定一個整數陣列 `height`，其中每個元素代表一條豎直線的高度，位置由索引決定。
任意兩條線與 x 軸可以構成一個容器，容器能裝的水量取決於較短的那條線。

請找出能容納最多水的容器，並回傳最大水量。

---

## 範例

* Input: `height = [1,8,6,2,5,4,8,3,7]` → Output: `49`
* Input: `height = [1,1]` → Output: `1`

---

## 解法概念

### 方法：雙指針 (Two Pointers)

1. 設定左右指針 `left=0`, `right=n-1`。
2. 計算區間水量：`min(height[left], height[right]) * (right - left)`。
3. 更新最大值。
4. 移動較短的邊，因為移動較長邊不會帶來更大水量。
5. 持續迭代直到 `left >= right`。

---

## 時間與空間複雜度

* **時間複雜度：** O(n)，僅需遍歷一次。
* **空間複雜度：** O(1)，常數額外空間。

---

## 關鍵重點

* 每次計算水量由 **短板效應** 決定。
* 移動較短的邊能保證不錯過最大值。