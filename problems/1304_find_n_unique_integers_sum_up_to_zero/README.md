# 1304 Find N Unique Integers Sum up to Zero

**LeetCode Link:** [1304. Find N Unique Integers Sum up to Zero](https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/)  
**Difficulty:** Easy  
**Tags:** Array, Math

---

## 題目描述
給定一個整數 `n`，請回傳一個長度為 `n` 的整數陣列：  
- 陣列中的整數 **互不相同**  
- 陣列中的整數總和為 `0`

可能有多個正確答案，任意一組都可。

---

## 解法概念

### 方法
- 因為正確答案任意一組就可以，最簡單方法就是從 `arr[i] = i` 一直塞到 `arr[n-2] = n-2`
- 最後塞入 `arr[n-1] = -sum(1...n-2)` 即可

---

## 時間與空間複雜度
- **時間複雜度:** O(n)  
- **空間複雜度:** O(1) (額外)