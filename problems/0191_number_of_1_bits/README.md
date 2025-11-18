# 191 Number of 1 Bits

**LeetCode Link:** [191. Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)
**Difficulty:** Easy
**Tags:** Bit Manipulation

---

## 題目描述

給定一個 **unsigned integer**，回傳其二進位表示中 **位元為 `1` 的個數**（也稱為 Hamming Weight）。

---

### 範例

**Input**

```
n = 00000000000000000000000000001011
```

**Output**

```
3
```

**Explanation:** 共有三個 `1`。

**Input**

```
n = 00000000000000000000000010000000
```

**Output**

```
1
```

**Input**

```
n = 11111111111111111111111111111101
```

**Output**

```
31
```

---

## 解法概念

### 方法一：位元運算逐位檢查

每次用 `n & 1` 判斷最後一位是否為 `1`，之後 `n >>= 1` 右移。

```python
def hammingWeight(n):
    count = 0
    while n:
        count += n & 1
        n >>= 1
    return count
```

---

### 方法二：Brian Kernighan 演算法（更快）

每次執行 `n & (n - 1)` **會移除最右邊的一個 `1`**，直到 `n = 0`。

```python
def hammingWeight(n):
    count = 0
    while n:
        n &= n - 1
        count += 1
    return count
```

> 此寫法比逐位檢查更快，因為迴圈次數為「1 的數量」。

---

### 方法三：Python 內建（最簡潔）

```python
def hammingWeight(n):
    return bin(n).count("1")
```

---

## 時間與空間複雜度

| 方法          | 時間複雜度 | 空間複雜度 | 備註        |
| ----------- | ----- | ----- | --------- |
| 逐位檢查        | O(32) | O(1)  | 固定長度      |
| n & (n-1)   | O(k)  | O(1)  | k = 1 的數  |
| bin().count | O(32) | O(1)  | Python 內建 |

> 由於題目限制輸入為 32-bit integer，因此上述方法的時間都等價於 O(1)。

---

## 核心關鍵

* 使用 `n & (n - 1)` 可有效消除最右邊的一個 `1`
* Python 使用 `bin()` 時注意類型轉換為無號整數
* 多數語言都針對這題提供內建最佳化方法（例如 Java 的 `Integer.bitCount(n)`）
