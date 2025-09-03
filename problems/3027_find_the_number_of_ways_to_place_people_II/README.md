# 3027 Find the Number of Ways to Place People II

**LeetCode Link:** [3027. Find the Number of Ways to Place People II](https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii/)  
**Difficulty:** Hard  
**Tags:** Geometry, Array, Sorting, Enumeration

---

## 題目描述
題意與 3025 類似，但條件更嚴格。  
你有一組 `points`，每個點表示一個人站的位置 `[x_i, y_i]`。  
同樣你要選兩個人：
- **Alice** 站在矩形的 **左上角** (x1, y1)  
- **Bob** 站在矩形的 **右下角** (x2, y2)

不同的是，這回更嚴格——**矩形內（包含邊界）絕對不能有其他人**。  
也就是，Alice 與 Bob 的矩形必須空無一人。

> 本質上跟 3025 一樣，只是題目敘述變長，難度變 Hard

---

## 解法概念

### 方法：排序 + 枚舉 + `maxY` 剪枝
1. **排序規則**  
   - 按 `x` 升序  
   - `x` 相同時，`y` 降序  

2. **枚舉每個可能的左上點 (Alice)**  
   - 對每個候選右下點 (Bob)，檢查是否滿足：  
     - `x2 > x1` 且 `y2 <= y1`（確保是矩形的左上與右下方向正確）  
     - 且在這兩點之間，所有其他人的 `y` 值都必須小於所有選中點的 `y`（即維持 `maxY` 幫助過濾有其他人在矩形內）。

3. 這樣可確保矩形邊界與內部沒有被「其他人」佔據。