# 21 Merge Two Sorted Lists

**LeetCode Link:** [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
**Difficulty:** Easy
**Tags:** Linked List, Recursion, Two Pointers

---

## 題目描述

給定兩個 **已排序的鏈結串列**，將它們合併成一個新的排序鏈結串列，並返回該鏈結串列的頭節點。

---

### 範例

**Input**

```
l1 = [1,2,4], l2 = [1,3,4]
```

**Output**

```
[1,1,2,3,4,4]
```

**Input**

```
l1 = [], l2 = []
```

**Output**

```
[]
```

**Input**

```
l1 = [], l2 = [0]
```

**Output**

```
[0]
```

---

## 解法概念

### 方法一：遞迴（Recursion）

* 思路：

  1. 比較 `l1.val` 與 `l2.val`
  2. 較小的節點成為合併後的頭
  3. 對剩下的節點呼叫遞迴，連接到頭節點的 `next`
* 代碼示意：

```java
if (l1 == null) return l2;
if (l2 == null) return l1;
if (l1.val < l2.val) {
    l1.next = mergeTwoLists(l1.next, l2);
    return l1;
} else {
    l2.next = mergeTwoLists(l1, l2.next);
    return l2;
}
```

### 方法二：迭代（Iterative）

* 建立一個 dummy 節點作為合併後鏈表的起點
* 使用指標 `current` 指向最後一個節點
* 當兩個鏈表都有節點時：

  * 比較值大小，將較小節點接到 `current.next`
  * 移動對應鏈表指標與 `current`
* 將非空鏈表剩餘節點接到 `current.next`

---

## 時間與空間複雜度

* **時間複雜度：** O(n + m) → n 與 m 分別為兩個鏈表長度
* **空間複雜度：**

  * 遞迴：O(n + m) → 呼叫棧
  * 迭代：O(1) → 不使用額外空間
