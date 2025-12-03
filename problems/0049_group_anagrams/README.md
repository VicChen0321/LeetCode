# 0049. Group Anagrams

**LeetCode Link:** [https://leetcode.com/problems/group-anagrams/](https://leetcode.com/problems/group-anagrams/)
**Difficulty:** Medium
**Tags:** Array, Hash Table, String, Sorting

---

## 題目描述

給定一個字串陣列 `strs`，請將其中的字串依照 **Anagram（字母重組詞）** 分組。

你需要回傳：

* 所有字母重組詞群組
* 群組內的字串順序不重要
* 群組之間的順序也不重要

### 什麼是 Anagram？

如果兩個字串的「字母及其出現次數」完全相同（順序可不同），則它們是 anagram。

---

### 範例

**Example 1**

* Input:
  `["eat","tea","tan","ate","nat","bat"]`
* Output:

  ```
  [
    ["bat"],
    ["nat","tan"],
    ["ate","eat","tea"]
  ]
  ```

  解釋：

  * `"eat"`, `"tea"`, `"ate"` 互為 anagram
  * `"tan"`, `"nat"` 互為 anagram
  * `"bat"` 自成一組

**Example 2**

* Input: `[""]`
* Output: `[[""]]`

**Example 3**

* Input: `["a"]`
* Output: `[["a"]]`

---

## 解法概念

### 方法：Hash（依照字母頻率或排序後 key 分組）

最常見、最快速的方法是：

> **利用「相同字母組成的字串，其排序後結果必定相同」來分組。**

因此可：

1. 對每個字串進行 **排序**，例如：

   * `"eat" → "aet"`
   * `"tea" → "aet"`
   * `"ate" → "aet"`
     → 會得到相同的 key
2. 使用 HashMap（key: 排序後字串, value: list of anagrams）
3. 將所有對應到相同 key 的字串放在同一組即可。

---

### **替代方法（不排序）：字母計數法**

適用於字母範圍小（a–z）的情況：

1. 計算字串中各字母的 count（長度為 26 的陣列）
2. 將此陣列用作 key（如：`(1,0,0,1,3,...)`）
3. 因為相同字母分佈的字串 key 一定相同 → 得到同一組

此方法能避免排序，理論上更快。

---

### 為什麼有效？

因為 Anagram 的特性是：

> 兩個字串若是 Anagram，則它們擁有完全一致的字母組合（含出現次數）。

無論你用排序或計數，都能建立一個 **唯一代表字母組成的 key**。

> **關鍵 insight：Anagram 的本質是「字母組合相同」→ 建 key → 用 Hash 分類。**

---

## 時間與空間複雜度

若採用 **排序法**：

* **時間複雜度**：O(N · K log K)

  * N = 字串數量
  * K = 字串平均長度
  * 每個字串排序需要 O(K log K)
* **空間複雜度**：O(N · K)（儲存輸出與 HashMap）

若採用 **計數法**：

* **時間複雜度**：O(N · K)
* **空間複雜度**：O(N · K)

---

## 程式碼

### Python（排序法）

```python
class Solution:
    def groupAnagrams(self, strs):
        groups = {}

        for s in strs:
            key = ''.join(sorted(s))  # sorted string as key
            if key not in groups:
                groups[key] = []
            groups[key].append(s)

        return list(groups.values())
```

---

### Java（排序法）

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
```

---

### Python（計數法，避免排序）

```python
class Solution:
    def groupAnagrams(self, strs):
        groups = {}

        for s in strs:
            count = [0] * 26
            for ch in s:
                count[ord(ch) - ord('a')] += 1

            key = tuple(count)
            groups.setdefault(key, []).append(s)

        return list(groups.values())
```

---

## Dry Run

以 `["eat","tea","tan","ate","nat","bat"]` 為例：

| 字串  | 排序後 | HashMap 狀態                                     |
| --- | --- | ---------------------------------------------- |
| eat | aet | { "aet": ["eat"] }                             |
| tea | aet | { "aet": ["eat","tea"] }                       |
| tan | ant | { "aet": [...], "ant": ["tan"] }               |
| ate | aet | { "aet": ["eat","tea","ate"], "ant": ["tan"] } |
| nat | ant | { ..., "ant": ["tan","nat"] }                  |
| bat | abt | { ..., "abt": ["bat"] }                        |

最後輸出所有 value 即可。

---

## 常見錯誤陷阱

* ❌ 直接比較字串是否互為 anagram → O(N² · K) 太慢
* ❌ 用 list 當 HashMap key（不可 hash），要用 **string 或 tuple**
* ❌ 忘記 `return new ArrayList<>(map.values())`（Java）
* ❌ Key 沒有標準化（例如排序錯誤，或計數未轉成可 hash 的型別）
