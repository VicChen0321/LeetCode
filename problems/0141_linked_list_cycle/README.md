---

# 0141 - Linked List Cycle

**LeetCode Link:** [https://leetcode.com/problems/linked-list-cycle/](https://leetcode.com/problems/linked-list-cycle/)
**Difficulty:** Easy
**Tags:** Linked List, Two Pointers, Fast & Slow, Cycle Detection

---

## 題目描述

給你一個**單向鏈結串列（singly linked list）**的頭節點 `head`，
請判斷該鏈結串列中是否存在**環（cycle）**。

* 若某個節點的 `next` 指回前面已出現過的節點，即形成環
* 不允許修改原本的鏈結結構
* 回傳 `true` 或 `false`

### 範例

* Input: `head = [3,2,0,-4]`, `pos = 1` → Output: `true`
  尾節點連回索引 1（值為 2）的節點

* Input: `head = [1,2]`, `pos = 0` → Output: `true`
  尾節點連回索引 0

* Input: `head = [1]`, `pos = -1` → Output: `false`
  無環

> `pos` 僅用於說明測資，**不是函式輸入參數**。

---

## 解法概念

這題是 **Cycle Detection（判斷環）** 的標準題型。

### 方法：Two Pointers（Floyd’s Tortoise and Hare）

#### 核心想法

使用兩個指標：

* `slow`：一次走 1 步
* `fast`：一次走 2 步

若串列有環，`fast` 一定會在環中追上 `slow`。

若沒有環，`fast` 會先走到 `null`。

#### 演算法步驟

1. 初始化

   * `slow = head`
   * `fast = head`

2. 當 `fast != null` 且 `fast.next != null`：

   * `slow = slow.next`
   * `fast = fast.next.next`
   * 若 `slow == fast` → 有環，回傳 `true`

3. 迴圈結束仍未相遇 → 無環，回傳 `false`

#### 關鍵 insight

* 這不是碰巧相遇，而是**數學必然**
* 快慢指標是判斷 cycle 最省空間的方式
* 不需要記錄走過的節點

> 小提示：
> 若題目要求找「環的起點」，這題是那一題的前置題。

---

## 時間與空間複雜度

* **時間複雜度**：O(n)
* **空間複雜度**：O(1)
