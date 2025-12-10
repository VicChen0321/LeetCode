# 169. Majority Element

**LeetCode Link:** [https://leetcode.com/problems/majority-element/](https://leetcode.com/problems/majority-element/)
**Difficulty:** Easy
**Tags:** Array, Hash Table, Divide and Conquer, Sorting, Counting, Boyer–Moore Voting Algorithm

---

## 題目描述

找出一個在陣列中出現次數 **大於 floor(n/2)** 的元素（稱為 Majority Element）。
題目保證這個元素一定存在。

* 陣列長度為 n
* Majority element 出現次數 > n/2
* 必定唯一、必定存在

### 範例

* **Input:** nums = [3,2,3]
  **Output:** 3
  解釋：3 出現兩次，超過長度 3 的一半。

* **Input:** nums = [2,2,1,1,1,2,2]
  **Output:** 2
  解釋：2 出現 4 次，1 只出現 3 次。

---

## 解法概念

### 方法：Boyer–Moore Voting Algorithm（投票法）

這題的經典最佳解。利用「多數元素一定能在 pair 消除後留下來」的特性。

1. 設定一個 `candidate`（候選者）與一個 `count` = 0
2. 遍歷陣列

   * 若 `count == 0`，將目前元素設為 `candidate`
   * 若當前元素 == candidate，則 `count += 1`
   * 否則 `count -= 1`
3. 根據數學保證，多數元素會在整個投票過程中存活到最後
4. 最後的 `candidate` 即為答案

#### 為什麼可行？

* Majority element 的出現次數比所有其他元素總和還多
* 在不斷「配對抵消」的過程裡，其他元素再多也會被消掉
* 唯一能存活的是那個真正超過半數的元素

> 核心 insight：
> 「把不一樣的元素視為互相抵銷，最後剩下的必定是多數派。」

---

## 時間與空間複雜度

* **時間複雜度**：O(n) — 單次掃描
* **空間複雜度**：O(1) — 常數額外記憶體
