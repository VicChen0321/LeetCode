好的，我幫你整理 **LeetCode 20 Valid Parentheses** 的筆記，格式跟你之前的例子一致。

---

# 20 Valid Parentheses

**LeetCode Link:** [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
**Difficulty:** Easy
**Tags:** Stack, String

---

## 題目描述

給定一個只包含 `'('`, `')'`, `'{'`, `'}'`, `'['`, `']'` 的字串，判斷其是否 **有效**。

有效條件：

1. 左括號必須由相同類型的右括號閉合
2. 左括號必須以正確順序閉合

---

### 範例

**Input**

```
s = "()"
```

**Output**

```
true
```

**Input**

```
s = "()[]{}"
```

**Output**

```
true
```

**Input**

```
s = "(]"
```

**Output**

```
false
```

---

## 解法概念

### 方法：Stack（堆疊）

* 思路：

  1. 遇到左括號 → 推入 stack
  2. 遇到右括號 → 檢查 stack 頂端是否匹配
  3. 若不匹配或 stack 空 → 回傳 False
  4. 字串掃描完後，stack 若為空 → 有效

* Python 寫法：

```python
def isValid(s):
    stack = []
    mapping = {')':'(', '}':'{', ']':'['}
    
    for char in s:
        if char in mapping:
            top_element = stack.pop() if stack else '#'
            if mapping[char] != top_element:
                return False
        else:
            stack.append(char)
    return not stack
```

---

## 時間與空間複雜度

* **時間複雜度：** O(n) → 遍歷整個字串
* **空間複雜度：** O(n) → 最差情況所有左括號進入 stack

---

## 核心關鍵

* 使用 **stack** 保存尚未匹配的左括號
* 對每個右括號檢查 stack 頂端是否匹配
* 掌握字串掃描與 stack 操作
