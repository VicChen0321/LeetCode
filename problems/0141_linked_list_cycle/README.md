# 141 Linked List Cycle

**LeetCode Link:** [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)  
**Difficulty:** Easy  
**Tags:** Linked List, Two Pointers, Hashing

---

## 題目描述
給定一個單向鏈結串列的頭節點 `head`，判斷這個鏈結串列中是否存在 **環**。  

環的定義：某個節點的 `next` 指標指向了之前出現過的節點，造成無限循環。  

### 範例
- Input: `head = [3,2,0,-4], pos = 1` → Output: `true`  
- Input: `head = [1,2], pos = 0` → Output: `true`  
- Input: `head = [1], pos = -1` → Output: `false`  

---

## 解法概念

### 方法 1：快慢指針（Floyd Cycle Detection）
1. 設定兩個指標：
   - `slow`：一次走一步
   - `fast`：一次走兩步
2. 如果鏈結串列沒有環，`fast` 會先到達 `null`。  
3. 如果有環，`fast` 和 `slow` 終將相遇。  

此方法為經典解法，時間與空間都很優。

### 方法 2：HashSet
1. 用一個集合存放走過的節點。  
2. 如果遇到重複的節點 → 有環。  
3. 否則若走到 `null` → 無環。  

此方法直觀，但需額外 O(n) 空間。