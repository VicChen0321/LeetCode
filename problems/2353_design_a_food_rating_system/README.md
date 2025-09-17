# 2353. Design a Food Rating System

**LeetCode Link:** [2353. Design a Food Rating System](https://leetcode.com/problems/design-a-food-rating-system/)  
**Difficulty:** Medium  
**Tags:** Hash Table, Design, Heap, Ordered Set

---

## 題目描述
設計一個「食物評分系統」，需要支援以下操作：

- 初始化：  
  給定三個陣列：
  - `foods[i]`：第 `i` 個食物的名稱
  - `cuisines[i]`：`foods[i]` 的料理類型
  - `ratings[i]`：`foods[i]` 的初始評分

- `changeRating(food, newRating)`：更新食物的評分。  
- `highestRated(cuisine)`：回傳該料理類型中評分最高的食物名稱。  
  - 如果有多個，回傳字典序最小的食物名稱。

---

## 解法概念

### 方法：HashMap + 平衡樹結構（或 PriorityQueue）
1. **資料結構設計**
   - `foodToCuisine`：`food -> cuisine`
   - `foodToRating`：`food -> rating`
   - `cuisineToFoods`：`cuisine -> 有序集合(TreeSet or PriorityQueue)`  
     排序規則：
     - 先比 `rating` 降序
     - rating 相同則比食物名稱字典序升序

2. **操作流程**
   - 初始化時，把每個食物放進對應料理的 TreeSet。  
   - `changeRating`：更新時，先從料理集合刪掉舊的，再加上新的。  
   - `highestRated`：直接回傳料理集合的第一個元素（最高分，字典序最小）。

---

## 時間與空間複雜度
- **初始化:** O(n log n)  
- **changeRating:** O(log n)（刪除 + 插入）  
- **highestRated:** O(1)（取第一個元素）  
- **空間:** O(n)

---

## 關鍵重點
- 多個結構同步維護：`foodToCuisine`、`foodToRating`、`cuisineToFoods`  
- 使用 **有序集合 (TreeSet)**，能確保快速取最大值 + tie-break 字典序  
- 更新時要小心：必須先刪掉舊值再插入新值，否則會有重複。
  
> 如果是使用 PriorityQueue 的做法，因為沒辦法直接刪除舊值，所以在 `highestRated` 查詢時，要比對 rating map，如果值不相同代表已經過時，要 pop 掉
