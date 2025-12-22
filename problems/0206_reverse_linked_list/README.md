# 0206 - Reverse Linked List

**LeetCode Link:** [https://leetcode.com/problems/reverse-linked-list/](https://leetcode.com/problems/reverse-linked-list/)
**Difficulty:** Easy
**Tags:** Linked List, Two Pointers, Recursion

---

## 題目描述

給你一個**單向鏈結串列（singly linked list）**的頭節點 `head`，
請你將整個鏈結串列**反轉**，並回傳反轉後的新頭節點。

* 節點結構：`val` + `next`
* 不可改變節點的值，只能調整指標方向
* 可能是空串列或只有一個節點

### 範例

* Input: `head = [1,2,3,4,5]` → Output: `[5,4,3,2,1]`

* Input: `head = [1,2]` → Output: `[2,1]`

* Input: `head = []` → Output: `[]`

---

## 解法概念

這題是 **Linked List 的第一道必考題**，本質是「**反轉指標方向**」。

### 方法：Iterative（Two Pointers）

#### 核心想法

在走訪串列時，把每個節點的 `next` 指回前一個節點。

你只需要三個指標：

* `prev`：已反轉好的前一個節點
* `curr`：目前正在處理的節點
* `nextTemp`：暫存下一個節點（避免斷鏈）

#### 演算法步驟

1. 初始化

   * `prev = null`
   * `curr = head`

2. 當 `curr != null` 時：

   1. 暫存 `curr.next` 到 `nextTemp`
   2. 將 `curr.next` 指向 `prev`
   3. `prev = curr`
   4. `curr = nextTemp`

3. 當迴圈結束：

   * `prev` 即為新的頭節點

#### 關鍵 insight

* **一定要先存 `next`，再改指標**
  否則鏈結會直接斷掉
* 每一步都在「把一個節點搬到新串列前面」

> 小提示：
> 如果你畫得出指標變化圖，這題就不會寫錯。

---

## 時間與空間複雜度

* **時間複雜度**：O(n)
* **空間複雜度**：O(1)
