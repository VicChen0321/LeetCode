# 152 Maximum Product Subarray

**LeetCode Link:**
[152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)

**Difficulty:** Medium
**Tags:** Array, Dynamic Programming

---

## 題目描述

給定一個整數陣列 `nums`，找出其**連續子陣列（至少包含一個數）中乘積最大的值**，並回傳該乘積。

---

### 範例

**Input**

```
nums = [2,3,-2,4]
```

**Output**

```
6
```

**解釋**

* `2 * 3 = 6`

---

**Input**

```
nums = [-2,0,-1]
```

**Output**

```
0
```

**解釋**

* 最佳子陣列為 `[0]`

---

## 解法概念

### 方法：DP (同時追蹤 max 與 min)

由於乘積遇到 **負數會翻轉大小**，因此：

* 需要追蹤當前位置的 **最大乘積 (`maxProd`)**
* 也需追蹤 **最小乘積 (`minProd`)**（因為負負得正）

```
maxProd[i] = max(nums[i], nums[i] * maxProd[i-1], nums[i] * minProd[i-1])
minProd[i] = min(nums[i], nums[i] * maxProd[i-1], nums[i] * minProd[i-1])
```

例子：
`nums = [-2, 3, -4]`

| i | num | maxProd | minProd | result |
| - | --- | ------- | ------- | ------ |
| 0 | -2  | -2      | -2      | -2     |
| 1 | 3   | 3       | -6      | 3      |
| 2 | -4  | 24      | -12     | 24     |

---

## 時間與空間複雜度

| 項目        | 複雜度           |
| --------- | ------------- |
| **時間複雜度** | O(n)          |
| **空間複雜度** | O(1)（用滾動變數即可） |

---

## 核心關鍵

* **遇到負數時要交換 max 和 min**
* **每一步都重新來過**（因為若當前數值本身比乘積更大，要讓 subarray 重新開始）
* 適合面試的技巧題，考對 DP 思維掌握程度
