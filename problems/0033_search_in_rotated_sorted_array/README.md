# 33 Search in Rotated Sorted Array

**LeetCode Link:**
[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

**Difficulty:** Medium
**Tags:** Array, Binary Search

---

## 題目描述

給定一個**升序排序後被旋轉的陣列** `nums`，以及一個目標值 `target`，在陣列中尋找目標值的位置，如果不存在則回傳 `-1`。

* 假設陣列中不含重複值
* 必須在 O(log n) 時間內完成搜尋

---

### 範例

**Input**

```
nums = [4,5,6,7,0,1,2], target = 0
```

**Output**

```
4
```

---

**Input**

```
nums = [4,5,6,7,0,1,2], target = 3
```

**Output**

```
-1
```

---

## 解法概念

### 方法：修改版二分搜尋

旋轉後陣列有一個特性：

* 左半段或右半段 **必定是有序的**
* 可以利用這個特性決定往左或往右搜尋

步驟：

1. 設 `left = 0`, `right = n-1`
2. 迴圈 `while left <= right`：

   * 計算 mid = (left + right) / 2
   * 若 nums[mid] == target → return mid
   * 判斷哪一半是有序：

     * 若 nums[left] <= nums[mid]：左半段有序

       * 如果 target 在 [nums[left], nums[mid]] → right = mid-1
       * 否則 → left = mid+1
     * 否則右半段有序

       * 如果 target 在 [nums[mid], nums[right]] → left = mid+1
       * 否則 → right = mid-1
3. 若迴圈結束仍未找到 → return -1

---

## 時間與空間複雜度

| 項目        | 複雜度      |
| --------- | -------- |
| **時間複雜度** | O(log n) |
| **空間複雜度** | O(1)     |

---

## 核心關鍵

* 利用旋轉陣列的 **有序區間**
* 每次二分判斷哪半段有序
* 確定有序段後判斷 target 是否在該段
* 是二分搜尋變形，面試常考
