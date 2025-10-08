# 2300. Successful Pairs of Spells and Potions

**LeetCode Link:** [2300. Successful Pairs of Spells and Potions](https://leetcode.com/problems/successful-pairs-of-spells-and-potions/)  
**Difficulty:** Medium  
**Tags:** Array, Sorting, Binary Search, Two Pointers  

---

## 題目描述

給你兩個正整數陣列 `spells` 和 `potions`，分別長度為 `n` 和 `m`，還有一個整數 `success`。  
我們稱一個 pair `(spell, potion)` 是 **成功的**，當且僅當：`spell_strength × potion_strength ≥ success`

對於每一個 `spells[i]`，請你找出可以與之搭配組成成功 pair 的 `potions` 數量。  
回傳一個整數陣列 `pairs`（長度為 `n`），其中 `pairs[i]` 是 `spells[i]` 成功 pair 的數量。

---

## 範例

- Input: `spells = [5,1,3]`, `potions = [1,2,3,4,5]`, `success = 7` → Output: `[4,0,3]`  
  - spell=5: 搭配 potions 中的 2,3,4,5 → 4 種  
  - spell=1: 搭配任何 potion 都不滿足 ≥ 7 → 0  
  - spell=3: 搭配 3,4,5 → 3 種  

- Input: `spells = [3,1,2]`, `potions = [8,5,8]`, `success = 16` → Output: `[2,0,2]`  

---

## 解法概念

### 方法：排序 + 二分搜尋

1. **排序 potions** 陣列  
2. 對於每個 `spell`：
   - 求最小的 `potion` 強度門檻：`ceil(success / spell)`  
   - 在 sorted `potions` 中用二分搜尋找第一個 ≥ 門檻的 index `idx`  
   - 成功配對數量 = `m - idx`  
3. 回傳結果陣列

---

## 時間與空間複雜度

- **時間複雜度：** O(m log m + n log m)  
- **空間複雜度：** O(1) 額外空間（除了輸出用）  