# 0067 — Add Binary

**LeetCode Link:** [https://leetcode.com/problems/add-binary/](https://leetcode.com/problems/add-binary/)
**Difficulty:** Easy
**Tags:** String, Math, Binary

---

## 題目描述

給你兩個**二進位字串** `a` 與 `b`，請回傳它們相加後的**二進位結果（字串形式）**。

* 只能使用字串操作，不可直接把字串轉成大整數。
* 注意進位。
* 輸入字串只包含 `'0'` 與 `'1'`。

### 範例

* **Input:** a = `"11"`, b = `"1"`
  **Output:** `"100"`
  解釋：3 + 1 = 4 → 二進位為 100

* **Input:** a = `"1010"`, b = `"1011"`
  **Output:** `"10101"`
  解釋：10 + 11 = 21 → 二進位為 10101

---

## 解法概念

### 方法：Two Pointers（從尾端往前加）

此題的本質就是模擬「手算二進位加法」，像小學算十進位一樣，只是 base = 2。

1. **從字串最後一位開始處理**

   * 使用兩個指標 `i`、`j` 分別指向 `a`、`b` 的最後一位。
   * 因為二進位的低位在右邊。

2. **逐位相加並處理進位**

   * 每一輪計算：`sum = carry + bit(a) + bit(b)`
   * 新位元 = `sum % 2`
   * 更新進位 = `sum / 2`

3. **處理不同長度的字串**

   * 若 `i`、`j` 超出邊界，視為 0。

4. **最後若有進位，補上**

   * 例如 1 + 1 = 10，要補一個 '1' 在最前面。

5. **由於我們是從低位往前算，結果需反轉**

   * 使用 `StringBuilder` 最方便。

**關鍵 insight：**

* 二進位相加不用轉整數，用字串「手動相加」就能做到。
* 進位只有 0 或 1，運算簡單。

---

## 時間與空間複雜度

* **時間複雜度**：O(n)，n 為較長字串長度
* **空間複雜度**：O(n)，用於儲存答案

---

## 程式碼範例

### Java

```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }
}
```

### Python

```python
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        i, j = len(a) - 1, len(b) - 1
        carry = 0
        res = []

        while i >= 0 or j >= 0 or carry:
            total = carry

            if i >= 0:
                total += int(a[i])
                i -= 1
            if j >= 0:
                total += int(b[j])
                j -= 1

            res.append(str(total % 2))
            carry = total // 2

        return "".join(res[::-1])
```

---

## Dry Run（示例：a = “1010”, b = “1011”）

```
    1010
  + 1011
  -------
i/j從右端開始：

0 + 1 + carry0 → 1, carry0
1 + 1 + carry0 → 0, carry1
0 + 0 + carry1 → 1, carry0
1 + 1 + carry0 → 0, carry1
最後補上 carry = 1 → 結果為 10101
```

---

## 常見錯誤陷阱

* 忘記最後的進位要加入。
* 反轉順序寫錯（append 後需要 reverse）。
* 用 `+=` 直接對字串累加導致效能差（Java 應用 `StringBuilder`）。
