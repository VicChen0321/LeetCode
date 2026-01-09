# 232. Implement Queue using Stacks

**LeetCode Link:** [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

**Difficulty:** Easy

**Tags:** Stack, Design, Queue

---

## 題目描述

這題要求我們使用兩個 **Stack（後進先出 LIFO）** 來模擬出一個 **Queue（先進先出 FIFO）** 的行為。需要實作以下四個功能：

* `push(x)`：將元素加入隊伍末尾。
* `pop()`：從隊伍開頭移除並回傳元素。
* `peek()`：回傳隊伍開頭的元素（不移除）。
* `empty()`：判斷隊伍是否為空。

**限制與需求：**

* 只能使用標準的 Stack 操作（`push` to top, `peek/pop` from top, `size`, `is empty`）。
* 雖然某些操作在最壞情況下是 $O(n)$，但題目要求嘗試達到 **均攤（Amortized）時間複雜度** $O(1)$。

### 範例

* **Input:**
`["MyQueue", "push", "push", "peek", "pop", "empty"]`
`[[], [1], [2], [], [], []]`
* **Output:**
`[null, null, null, 1, 1, false]`
* **解釋:**

1. `push(1)`: Queue 為 [1]
2. `push(2)`: Queue 為 [1, 2]
3. `peek()`: 回傳 1
4. `pop()`: 回傳 1，Queue 變為 [2]
5. `empty()`: 回傳 false

---

## 解法概念

### 方法：雙 Stack 緩衝法（In-stack & Out-stack）

單個 Stack 無法完成 Queue 的功能，因為順序是反的。但如果我們把一個 Stack 的元素全部倒入另一個 Stack，順序就會被「反轉」兩次，進而恢復成先進先出的順序。

1. **準備兩個 Stack**：

* `s1` (In-stack)：專門負責接收新加入的資料（push）。
* `s2` (Out-stack)：專門負責輸出資料（pop / peek）。

1. **Push 操作**：

* 直接將元素丟進 `s1`。這部分的時間複雜度永遠是 $O(1)$。

1. **Pop / Peek 操作**：

* 如果 `s2` 是空的，我們把 `s1` 所有的元素逐一 `pop` 並 `push` 進入 `s2`。
* 此時 `s2` 的頂端就是最先進入的元素，直接從 `s2` 進行操作。
* 如果 `s2` 不為空，則直接取 `s2` 的頂端元素。

1. **關鍵 Insight**：

* 元素只有在 `s2` 為空時才會發生大規模搬移。每個元素一生只會從 `s1` 進入一次，並從 `s2` 出去一次，因此長期來看，平攤到每個操作的時間是常數。

> **小提示：** 在實作 `pop()` 時，可以直接呼叫已經寫好的 `peek()` 來簡化程式碼（因為搬移邏輯是一樣的）。

---

## 時間與空間複雜度

* **時間複雜度**：
* `push`:$O(1)$
* `pop / peek`: **均攤 (Amortized) $O(1)$**。雖然單次搬移可能需要 $O(n)$ ，但大部分時候直接操作 `s2` 僅需 $O(1)$。
* `empty`$O(1)$:

* **空間複雜度**：$O(n)$，需要儲存 $n$ 個元素的空間。
