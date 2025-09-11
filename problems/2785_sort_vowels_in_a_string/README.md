# 2785 Sort Vowels in a String

**LeetCode Link:** [2785. Sort Vowels in a String](https://leetcode.com/problems/sort-vowels-in-a-string/)  
**Difficulty:** Medium  
**Tags:** String, Sorting

---

## 題目描述  
給定一個 0-indexed 字串 `s`，要求產生一個新字串 `t`，滿足：

- 所有子音（consonants）在 `t` 中必須保持與 `s` 中相同的字元與原位置。
- 所有母音（vowels）必須依 ASCII 值 **非遞減順序排序**，並填回原先母音所在的位置。

母音定義：`a, e, i, o, u`（皆可為大寫或小寫）。

例如：  
輸入 `"lEetcOde"` → 輸出 `"lEOtcede"`  
- 原母音序列是 `['E', 'e', 'O', 'e']`，排序後 `['E', 'O', 'e', 'e']`，再依序填回母音位置。

---

## 解法概念

### 方法：提取 + 排序 + 替換
1. **提取母音**  
   遍歷 `s`，把是母音的字元收集到列表 `vowels`。

2. **排序母音**  
   對 `vowels` 進行排序（ASCII 預設即可，注意大寫字母 ASCII 較小，會排前面）。

3. **重建字串**  
   把 `s` 轉為可變字元陣列 `cs`，再遍歷 `cs`，遇到母音時取 `vowels` 的下一個字元替換，子音則保持不動。

4. **Join 回字串**  
   最後組合 `cs` 為新的字串 `t` 返回。

---

## 時間與空間複雜度  
- **時間複雜度:** O(n log n) — 因母音排序最壞需要 O(k log k)，k 最多接近 n  
- **空間複雜度:** O(n) — 額外存母音列表 + 可變字元陣列

---

## 關鍵重點  
- 只對母音排序，子音保位置  
- 排序時 ASCII 值自帶大寫在前、小寫在後的行為符合題意  
- 轉換 Immutable 字串時記得用可變結構（如 char 陣列或 StringBuilder）
