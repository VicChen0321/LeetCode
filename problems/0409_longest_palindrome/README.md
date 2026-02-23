# 409. Longest Palindrome

**LeetCode Link:** [409. Longest Palindrome](https://leetcode.com/problems/longest-palindrome/)

**Difficulty:** Easy

**Tags:** Hash Table, String, Greedy

---

## 題目描述

給定一個包含大寫與小寫字母的字串 `s`，請計算出用這些字母可以組成最長的 **迴文（Palindrome）** 長度是多少。

* **注意**：區分大小寫，例如 `"Aa"` 不被視為迴文。
* **迴文定義**：正著讀和反著讀都一樣的字串。

### 範例

* **Input:** s = "abccccdd" → **Output:** 7
* **解釋**: 可以組成最長迴文之一是 "dccaccd"，長度為 7。

* **Input:** s = "a" → **Output:** 1
* **Input:** s = "aaaaaa" → **Output:** 6

---

## 解法概念

### 方法：貪婪演算法 + 哈希表計數（Greedy with Frequency Counter）

要構成一個迴文，字母的排列邏輯如下：

1. **成雙成對**：絕大部分字母必須成對出現（一左一右對稱），例如兩個 'c'、兩個 'd'。
2. **中心點**：迴文的中間可以放 **一個** 孤單的字母（或是成對字母中剩下的一個）。

**實作步驟：**

1. **統計字頻**：使用哈希表或陣列統計每個字元出現的次數。
2. **計算偶數部分**：

* 遍歷每個字元的次數。如果某個字元出現 $k$ 次，則它可以貢獻 $(k // 2) \times 2$ 個長度到迴文中（即取最大的偶數）。
* 例如：'c' 出現 4 次，貢獻 4；'a' 出現 3 次，貢獻 2。

1. **處理中心點**：

* 如果在統計過程中發現任何字元的次數是 **奇數**，代表我們可以挑選其中一個放在迴文的最中間。
* 只要有任何一個奇數次數存在，最終結果就再 **+1**。

> **關鍵 Insight**：不需要真的構造出字串，只需要算數量。關鍵公式為：`ans += count / 2 * 2`，最後若有剩餘奇數則 `ans += 1`。

---

## 時間與空間複雜度

* **時間複雜度**：$O(n)$
* $n$ 為字串長度，需遍歷一次字串進行計數，再遍歷一次哈希表（最多 52 個字元）。

* **空間複雜度**： $O(1)$ 或 $O(k)$
* 雖然使用了哈希表，但字元集固定（大寫+小寫英文字母共 52 個），空間消耗不隨 $n$ 增長。

---

## 程式碼（Python / Java）

### Python (Greedy)

```python
class Solution:
    def longestPalindrome(self, s: str) -> int:
        res = 0
        counts = collections.Counter(s)
        has_odd = False
        
        for count in counts.values():
            # 取最大偶數部分：如果是 3，(3 // 2) * 2 = 2
            res += (count // 2) * 2
            # 檢查是否有奇數剩餘
            if count % 2 == 1:
                has_odd = True
        
        # 如果有任何一個字母剩單數，可以放在正中間
        return res + 1 if has_odd else res

```

### Java (Array Counter)

```java
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128]; // 涵蓋所有 ASCII
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        for (int v : count) {
            length += (v / 2) * 2;
            // 如果目前長度是偶數且還有剩餘字母，代表可以放一個在中間
            if (length % 2 == 0 && v % 2 == 1) {
                length++;
            }
        }
        return length;
    }
}

```

---

## 常見錯誤陷阱

1. **忘記區分大小寫**：'A' 和 'a' 是不同的，統計時不能合併。
2. **重複加 1**：中心點只能有一個。在迴圈中要控制好，一旦加過那個「1」，之後就算還有其他奇數字母，也只能取它們的偶數部分（例如某字母出現 3 次，只能拿 2 個用，剩下 1 個不能再放中間）。
