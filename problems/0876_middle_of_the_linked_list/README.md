# 0876 - Middle of the Linked List

**LeetCode Link:** [https://leetcode.com/problems/middle-of-the-linked-list/](https://leetcode.com/problems/middle-of-the-linked-list/)
**Difficulty:** Easy
**Tags:** Linked List, Two Pointers, Fast & Slow

---

## 題目描述

給你一個**單向鏈結串列（singly linked list）**的頭節點 `head`，
請找出並回傳**鏈結串列的中間節點**。

* 若鏈結串列長度為 **偶數**，回傳**第二個中間節點**
* 節點結構包含 `val` 與 `next`
* 串列長度至少為 1

### 範例

* Input: `head = [1,2,3,4,5]` → Output: `[3,4,5]`
  中間節點是 `3`

* Input: `head = [1,2,3,4,5,6]` → Output: `[4,5,6]`
  有兩個中間點（3、4），回傳第二個 → `4`

---

## 解法概念

這題是 **Fast & Slow Pointer（快慢指標）** 的經典入門題。

### 方法：Two Pointers（Fast & Slow）

#### 核心想法

* `slow`：每次走 1 步
* `fast`：每次走 2 步

當 `fast` 走到尾巴時，`slow` 剛好在中間。

#### 為什麼偶數要回傳第二個中間？

因為當長度為偶數時：

* `fast` 會剛好走到 `null`
* `slow` 會停在 **偏右的中間點**

這剛好符合題目要求，不用特別處理。

#### 演算法步驟

1. 初始化

   * `slow = head`
   * `fast = head`

2. 當 `fast != null` 且 `fast.next != null`：

   * `slow = slow.next`
   * `fast = fast.next.next`

3. 迴圈結束時：

   * `slow` 即為答案

#### 關鍵 insight

* 快慢指標可以**一次遍歷**就拿到中間位置
* 不需要先算長度，也不需要額外空間
* 這個技巧會在大量 Linked List 題反覆出現

> 小提示：
> 若題目改成「回傳第一個中間」，初始化 `fast = head.next` 即可。

---

## 時間與空間複雜度

* **時間複雜度**：O(n)
* **空間複雜度**：O(1)
