# 0048. Rotate Image

**LeetCode Link:** [https://leetcode.com/problems/rotate-image/](https://leetcode.com/problems/rotate-image/)
**Difficulty:** Medium
**Tags:** Array, Matrix, Simulation

---

## 題目描述

給定一個 `n x n` 的正方形矩陣 `matrix`，要求 **就地 (in-place)** 將它 **順時針旋轉 90 度**。

要注意：

* 不能建立另一個矩陣來協助計算（必須 in-place 操作）
* `matrix[i][j]` 要旋轉到新的正確位置
* 處理時要避免覆蓋資料，因此旋轉順序很重要

### 範例

**Example 1**

* Input:

  ```
  matrix = [
    [1,2,3],
    [4,5,6],
    [7,8,9]
  ]
  ```

* Output:

  ```
  [
    [7,4,1],
    [8,5,2],
    [9,6,3]
  ]
  ```

**Example 2**

* Input:

  ```
  [
    [5,1,9,11],
    [2,4,8,10],
    [13,3,6,7],
    [15,14,12,16]
  ]
  ```

* Output:

  ```
  [
    [15,13,2,5],
    [14,3,4,1],
    [12,6,8,9],
    [16,7,10,11]
  ]
  ```

---

## 解法概念

### 方法：Matrix 操作（Transpose + Reverse）

此題的經典技巧是：

> **先轉置（transpose）矩陣，再反轉每一 row，即可完成 90 度順時針旋轉。**

#### **1. Transpose（轉置矩陣）**

把 `matrix[i][j]` 與 `matrix[j][i]` 交換。

轉置後矩陣會「沿著主對角線翻轉」。

#### **2. Reverse each row（反轉每一列）**

將轉置後的每一列做 reverse。

這個操作會把矩陣從左到右翻轉，搭配轉置剛好達到 90 度順時針旋轉效果。

---

### 為什麼這樣就能旋轉？

* **轉置**：將行與列交換，讓資料位置部分對齊旋轉結果
* **反轉 row**：將資料推到正確的最終位置

想像原本在左邊的元素，被推到上方，再因為 row 反轉推到右邊，形成順時針效果。

> **關鍵 insight：順時針旋轉 = 轉置 + 每 row 反轉**
> 這是矩陣旋轉問題最常用的優雅解法。

---

## 時間與空間複雜度

* **時間複雜度**：O(n²) — 轉置與反轉都要掃過整個矩陣
* **空間複雜度**：O(1) — 就地操作，不使用額外矩陣

---

## 程式碼

### Python

```python
class Solution:
    def rotate(self, matrix):
        n = len(matrix)

        # 1. transpose
        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

        # 2. reverse each row
        for i in range(n):
            matrix[i].reverse()
```

### Java

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. reverse each row
        for (int i = 0; i < n; i++) {
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                int tmp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = tmp;
            }
        }
    }
}
```

---

## Dry Run（以 3×3 為例）

原始：

```
1 2 3
4 5 6
7 8 9
```

**Step 1: 轉置**

```
1 4 7
2 5 8
3 6 9
```

**Step 2: 每 row 反轉**

```
7 4 1
8 5 2
9 6 3
```

完成！

---

## 常見錯誤陷阱

* ❌ 使用額外矩陣（不符合 in-place 要求）
* ❌ 轉置時 j 從 0 開始 → 會交換兩次（造成錯誤）

  * 正確寫法：`for j in range(i+1, n)`
* ❌ row 反轉時寫錯 index 或沒確實交換
* ❌ 把 transpose 與 reverse 順序寫反
