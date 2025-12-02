# 23 Merge k Sorted Lists

**LeetCode Link:** [https://leetcode.com/problems/merge-k-sorted-lists/](https://leetcode.com/problems/merge-k-sorted-lists/)
**Difficulty:** Hard
**Tags:** Linked List, Divide and Conquer, Heap (Priority Queue), Merge Sort

---

## 題目描述

給定一個包含 `k` 個**已排序**（遞增）的 linked lists 的陣列 `lists`，每個 list 都是單向鏈結串列。請將這 `k` 個排序鏈結串列合併成一個排序後的單一鏈結串列。

* 必須保持排序。
* 回傳新的合併後的頭節點。
* 若某些 list 為空，需能安全處理。

### 範例

* Input:
  `lists = [[1,4,5],[1,3,4],[2,6]]`
  Output:
  `[1,1,2,3,4,4,5,6]`
  解釋：依序將所有 list merge，保持排序。

* Input: `lists = []` → Output: `[]`

* Input: `lists = [[]]` → Output: `[]`

---

## 解法概念

### 方法：最小堆（Min-Heap / Priority Queue）

1. 因為每個 list 都是**已排序**，每條鏈結串列的「最小值」都在其頭部。
2. 使用 Min-Heap，把每個 list 的「第一個節點」丟進 heap，讓 heap 自動維護最小值在頂端。
3. 每次從 heap 取出最小的節點，將它接到合併後的結果串列後面。
4. 若取出的節點還有下一個節點，將該「下一個」推入 heap。
5. 持續重複直到 heap 空為止。

#### 重點直覺

* 每次要從所有 list 的 head 找最小值 → heap 很適合保持動態最小值。
* k 個 list，但每個 list 全部節點只 push / pop 一次。
* 這比「逐一掃描 k 個 list」更有效率（那會是 O(nk)）。

> **邊界情況**：
>
> * lists 為空 → 回傳空
> * list 裡全部是空 → 回傳空
> * 單條 list 直接回傳即可

---

## 時間與空間複雜度

* **時間複雜度**：O(N log k)

  * N = 所有鏈結串列節點總數
  * 每個節點最多 push + pop heap 一次
  * heap 內最多 k 個元素（每條 list 的頭）

* **空間複雜度**：O(k)

  * Min-heap 最多存 k 個節點
  * 若忽略 output linked list（因為是題目要求）

---

## 常見錯誤陷阱

* 忘記檢查 list 為 null。
* Python heapq 無法比較 ListNode，需要加 `(val, index, node)`。
* 以為可以直接 merge list1 + list2 + ... + listk，再 sort → 時間會變 O(N log N)，不是最佳解。
