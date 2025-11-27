# 238 Product of Array Except Self

**LeetCode Link:**
[238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

**Difficulty:** Medium
**Tags:** Array, Prefix Sum, Suffix Product

---

## 題目描述

給定一個整數陣列 `nums`，返回一個陣列 `answer`，其中：

> `answer[i] = nums 陣列中所有元素的乘積，不包含 nums[i] 自己`

---

### 限制條件

* 不可使用除法 (`/`)
* 時間複雜度須為 **O(n)**
* 空間複雜度須為 **O(1)**（不包含輸出結果）

---

### 範例

**Input**

```
nums = [1, 2, 3, 4]
```

**Output**

```
[24, 12, 8, 6]
```

**解釋**

| Index | 值 | 左側乘積      | 右側乘積       | 結果 |
| ----- | - | --------- | ---------- | -- |
| 0     | 1 | 1         | 2×3×4 = 24 | 24 |
| 1     | 2 | 1         | 3×4 = 12   | 12 |
| 2     | 3 | 1×2 = 2   | 4          | 8  |
| 3     | 4 | 1×2×3 = 6 | 1          | 6  |

---

## 解法概念

### 方法：左右乘積（Two-pass）

先使用陣列 `answer` 儲存每個 index **左側的乘積**
再反向遍歷，用變數 `right` 累計 **右側乘積** 並乘上 `answer[i]`

---

### 計算公式

```text
answer[i] = 左側乘積 × 右側乘積
```

以左乘積來說：

```text
answer[i] = answer[i - 1] * nums[i - 1]
```

以右乘積來說（反向）：

```text
answer[i] *= right
right *= nums[i]
```

---

## 時間與空間複雜度

| 項目        | 複雜度                |
| --------- | ------------------ |
| **時間複雜度** | O(n)               |
| **空間複雜度** | O(1)（不計 output 陣列） |

---

## 核心關鍵

* **不得使用除法**
* 利用 **先左後右的乘積策略**
* 使用變數保存右側乘積，避免額外空間
* 只遍歷兩次即可完成

---

## Java 實作

```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];

    // Step 1: 儲存左側乘積
    answer[0] = 1;
    for (int i = 1; i < n; i++) {
        answer[i] = answer[i - 1] * nums[i - 1];
    }

    // Step 2: 累加右側乘積
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        answer[i] *= right;
        right *= nums[i];
    }

    return answer;
}
```
