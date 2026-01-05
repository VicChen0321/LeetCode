# 0704. Binary Search

**LeetCode Link:** [https://leetcode.com/problems/binary-search/](https://leetcode.com/problems/binary-search/)
**Difficulty:** Easy
**Tags:** Array, Binary Search

---

## 題目描述

給定一個**已排序**（升序）的整數陣列 `nums` 和一個目標值 `target`，請寫一個函數來搜尋 `nums` 中的 `target`。

* 如果 `target` 存在，返回其索引（index）。
* 如果不存在，返回 `-1`。
* **限制：** 演算法必須在  的時間複雜度內運行。

### 範例

**Example 1**

* Input: `nums = [-1,0,3,5,9,12]`, `target = 9`
* Output: `4`
* 解釋：9 出現在 `nums` 的索引 4 位置。

**Example 2**

* Input: `nums = [-1,0,3,5,9,12]`, `target = 2`
* Output: `-1`
* 解釋：2 不在 `nums` 中，故返回 -1。

---

## 解法概念

### 方法：二分搜尋法 (Binary Search)

這是一個標準的二分搜尋題目，核心在於利用陣列「已排序」的特性，每次迭代都排除掉一半的可能性。

1. **定義邊界**：
設定兩個指針，`left` 指向陣列開頭 (0)，`right` 指向陣列結尾 (`nums.length - 1`)。
2. **循環搜尋**：
當 `left <= right` 時，持續執行以下步驟：

* 計算中間點 `mid`。
* **比對 `nums[mid]` 與 `target**`：
* 若 `nums[mid] == target`：找到了，直接返回 `mid`。
* 若 `nums[mid] < target`：代表目標值在右半部（比中間值大），將搜尋範圍縮小至 `[mid + 1, right]`，即執行 `left = mid + 1`。
* 若 `nums[mid] > target`：代表目標值在左半部（比中間值小），將搜尋範圍縮小至 `[left, mid - 1]`，即執行 `right = mid - 1`。

1. **回傳結果**：
若迴圈結束仍未找到目標值，代表不存在，回傳 `-1`。

> **關鍵 Insight：** 計算 `mid` 時，為了防止整數溢位 (Integer Overflow)，建議使用 `left + (right - left) / 2` 而非 `(left + right) / 2`。雖然在 Python 不常見溢位，但在 Java/C++ 中這是重要細節。

---

## 時間與空間複雜度

* **時間複雜度**：
每次比較後搜尋區間都會減半，因此複雜度為對數級別。
* **空間複雜度**：
僅使用了常數個變數 (`left`, `right`, `mid`) 進行迭代，沒有使用額外空間。

---

### 常見錯誤陷阱

1. **While 條件判斷**：
容易混淆是用 `<` 還是 `<=`。若初始 `right = nums.length - 1`，則搜尋區間是閉區間 `[left, right]`，條件應為 `left <= right`。
2. **邊界更新**：
更新時必須是 `mid + 1` 或 `mid - 1`。若寫成 `left = mid` 或 `right = mid`，當區間只剩兩個元素或目標不存在時，極易造成無窮迴圈（Infinite Loop）。
