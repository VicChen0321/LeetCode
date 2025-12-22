# 0075 - Sort Colors

**LeetCode Link:** [https://leetcode.com/problems/sort-colors/](https://leetcode.com/problems/sort-colors/)
**Difficulty:** Medium
**Tags:** Two Pointers, Array, Sorting, In-place

---

## 題目描述

給你一個整數陣列 `nums`，元素只會是 `0`、`1`、`2`，分別代表三種顏色。
請**就地（in-place）**將陣列排序，使得相同顏色相鄰，並且順序為 `0 → 1 → 2`。

* 不可使用內建排序函式
* 需在 O(n) 時間內完成
* 需使用 O(1) 額外空間

### 範例

* Input: `nums = [2,0,2,1,1,0]` → Output: `[0,0,1,1,2,2]`
  將所有 0 放前面、1 在中間、2 在後面

* Input: `nums = [2,0,1]` → Output: `[0,1,2]`

* Input: `nums = [0]` → Output: `[0]`

---

## 解法概念

這題是經典的 **Dutch National Flag Problem（荷蘭國旗問題）**。
核心精神是：**一次掃描，用三個區間界線來維護狀態**。

### 方法：Two Pointers（Three-way partition）

我們維護三個指標：

* `low`：下一個應該放 `0` 的位置
* `mid`：目前正在檢查的指標
* `high`：下一個應該放 `2` 的位置

陣列被切成四個區段：

```
[ 0 ... low-1 ]     -> 全是 0
[ low ... mid-1 ]   -> 全是 1
[ mid ... high ]    -> 未處理
[ high+1 ... end ]  -> 全是 2
```

#### 演算法步驟

1. 初始化

   * `low = 0`
   * `mid = 0`
   * `high = n - 1`

2. 當 `mid <= high` 時重複：

   * 若 `nums[mid] == 0`

     * 與 `nums[low]` 交換
     * `low++`, `mid++`
   * 若 `nums[mid] == 1`

     * 正確位置，直接 `mid++`
   * 若 `nums[mid] == 2`

     * 與 `nums[high]` 交換
     * `high--`
     * **注意：mid 不動，因為換過來的值還沒檢查**

3. 結束時，陣列即完成排序

#### 關鍵 insight

* `mid` 只在確定當前值「已經歸位」時才前進
* 遇到 `2` 時不能急著 `mid++`，否則會漏檢元素
* 整個過程只掃一次陣列，完全 in-place

> 小提醒：
> 這題的重點不是排序，而是「分類（partition）」的思維。

---

## 時間與空間複雜度

* **時間複雜度**：O(n)
* **空間複雜度**：O(1)
