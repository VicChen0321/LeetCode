# 0153 Find Minimum in Rotated Sorted Array

**LeetCode Link:** [https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
**Difficulty:** Medium
**Tags:** Array, Binary Search

---

## 題目描述

給定一個 **經過旋轉的遞增排序陣列** `nums`（所有元素互不相同），找出其中的 **最小值**。

* 原始陣列為遞增排序，如 `[0,1,2,4,5,6,7]`
* 旋轉後可能變成 `[4,5,6,7,0,1,2]`
* 你需要在 **O(log n)** 時間內找到最小值 → 代表必須用 **Binary Search**

### 限制

* `nums.length >= 1`
* 所有數字 distinct（無重複）
* 必須 O(log n)

### 範例

* **Input:** `nums = [3,4,5,1,2]`
  **Output:** `1`
  因為旋轉後的最小值落在後段。

* **Input:** `nums = [4,5,6,7,0,1,2]`
  **Output:** `0`

* **Input:** `nums = [11,13,15,17]`
  **Output:** `11`
  陣列沒有被旋轉，最小值就是第一個。

---

## 解法概念

### 方法：Binary Search 找旋轉點（Pivot）

核心想法：
**旋轉陣列的最小值，就是 “第一個比右邊界大的轉折點之後的那個值”。**

使用 binary search 去決定該往哪邊縮小搜尋範圍：

---

### 解題步驟

1. 設定左右指標 `l = 0`, `r = n-1`
2. 若 `nums[l] < nums[r]`，代表陣列根本沒旋轉 → 回傳 `nums[l]`
3. 取中點 `mid = (l + r) / 2`
4. 檢查 mid 所在的位置：

   * 若 `nums[mid] > nums[r]` → 最小值一定在 **右邊**
     → `l = mid + 1`
   * 否則（`nums[mid] <= nums[r]`）→ 最小值一定在 **左邊或 mid**
     → `r = mid`
5. 最後 `l == r` 時就是最小值的位置。

---

### 關鍵 Insight

* **利用 nums[mid] 與 nums[r] 比較來判斷哪段是「有序區」**

  * 若 `mid` 在「左段」（較大）→ 往右找
  * 若 `mid` 在「右段」（較小）→ 往左找
* 不需要判斷是否與左邊比較，只要與右邊比即可。

> 旋轉 + 單調 + 無重複 → 這題非常經典二分。

---

## 時間與空間複雜度

* **時間複雜度：** O(log n)
* **空間複雜度：** O(1)

---

## 常見錯誤陷阱

❌ 用 linear search（違反 O(log n）
❌ 跟左邊比較（邏輯較複雜可行但非最佳解）
❌ 忘記判斷 array 沒旋轉的情況
❌ mid == r 或 mid == l 的邊界處理寫錯
