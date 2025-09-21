# 1912. Design Movie Rental System

**LeetCode Link:** [1912. Design Movie Rental System](https://leetcode.com/problems/design-movie-rental-system/)  
**Difficulty:** Hard  
**Tags:** Hash Table, Design, Heap, Ordered Set

---

## 題目描述
設計一個「電影租賃系統」，需要支援以下操作：

- **初始化**  
  給定 `n` 個商店、每個商店擁有不同的電影以及價格。

- **search(movie)**  
  回傳擁有該電影的 **商店 id**，並且排序規則是：
  1. 依價格升序
  2. 如果價格相同，依商店 id 升序  
  最多回傳前 5 筆。

- **rent(shop, movie)**  
  從指定商店租出該電影，表示該電影已不再可用。

- **drop(shop, movie)**  
  歸還該電影，使其重新可租。

- **report()**  
  回傳已租出的電影 `(shop, movie)`，排序規則是：
  1. 依價格升序
  2. 如果價格相同，再依 `shop id` 升序
  3. 再依 `movie id` 升序  
  最多回傳前 5 筆。

---

## 解法概念

### 方法：多個有序結構維護
1. **資料結構**
   - `movieToShops[movie]`：保存所有可租的 `(price, shop)`，需要能快速取出前 5 筆 → **有序集合 (TreeSet / SortedList / Heap)**
   - `shopMovieToPrice[(shop, movie)]`：記錄價格，用於 rent / drop 時快速查詢
   - `rented`：保存所有已租的 `(price, shop, movie)`，需要能快速取出前 5 筆 → **有序集合**

2. **操作流程**
   - `search(movie)` → 查詢 `movieToShops[movie]` 的前 5 筆  
   - `rent(shop, movie)` → 從 `movieToShops[movie]` 移除，並加入 `rented`  
   - `drop(shop, movie)` → 從 `rented` 移除，並加入 `movieToShops[movie]`  
   - `report()` → 回傳 `rented` 的前 5 筆

---

## 時間與空間複雜度
- **初始化:** O(n log n)  
- **search / report:** O(5) ≈ O(1)  
- **rent / drop:** O(log n)  
- **空間:** O(n)

---

## 關鍵重點
- 必須用 **有序集合 (Ordered Set)** 來維護「前 K 筆」  
- search 與 report 都是 **排序後的 top 5**  
- 多個資料結構必須保持同步（rented ↔ 可租電影）。
