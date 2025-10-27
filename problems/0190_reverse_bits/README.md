# 190 Reverse Bits

**LeetCode Link:** [190. Reverse Bits](https://leetcode.com/problems/reverse-bits/)
**Difficulty:** Easy
**Tags:** Bit Manipulation

---

## 題目描述

給定一個 **32-bit unsigned integer** `n`，請你返回它的 **bits 反轉後的數值**。

### 範例

Example 1
- Input: n = 43261596
- Output: 964176192
- Explanation:  
    | Integer   | Binary                           |
    | --------- | -------------------------------- |
    | 43261596  | 00000010100101000001111010011100 |
    | 964176192 | 00111001011110000010100101000000 |

Example 2
- Input: n = 2147483644
- Output: 1073741822
- Explanation:
    | Integer    | Binary                           |
    | ---------- | -------------------------------- |
    | 2147483644 | 01111111111111111111111111111100 |
    | 1073741822 | 00111111111111111111111111111110 |

---

## 解法概念

### 方法 1：逐位移動

- 初始化結果 `res = 0`
- 對於 32 位：
  - 取 `n` 的最低位 `bit = n & 1`
  - 將結果左移並加上 bit：`res = (res << 1) | bit`
  - n 右移：`n >>= 1`
- 最後返回 `res`

**優點：** 直覺簡單，O(1) 時間、O(1) 空間

```java
public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
        res = (res << 1) | (n & 1);
        n >>>= 1;
    }
    return res;
}
```

### 方法 2：分治 / 位元交換（進階）

- 將 32-bit 拆成 16/8/4/2/1 bits 逐步交換
- 可透過位運算 mask 來完成

**優點：** 更快，尤其需要多次呼叫 `reverseBits` 時

```java
n = (n >>> 16) | (n << 16);
n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
```

**適合場景：** 多次呼叫、性能敏感問題。
