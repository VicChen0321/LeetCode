# 3541 Find Most Frequent Vowel and Consonant

**LeetCode Link:** [3541. Find Most Frequent Vowel and Consonant](https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/)  
**Difficulty:** Easy  
**Tags:** Hash Table, String, Counting

---

## 題目描述
給你一個只含有小寫英文字母的字串 `s`。  
請你找到：

- 出現次數最多的 **母音**（`a, e, i, o, u`）  
- 出現次數最多的 **子音**（a-z 中非母音）  

返回這兩者出現次數的總和。  

注意事項：
- 如果有多個母音頻率相同最大，可以任選一個。
- 如果有多個子音頻率相同最大，也可以任選一個。
- 如果字串中沒有母音，其母音頻率視為 0。
- 如果字串中沒有子音，其子音頻率視為 0。

#### 範例
- Input: `s = "successes"` → Output: `6`  
  解釋：母音中最多的是 `'e'` 出現 2 次；子音中最多的是 `'s'` 出現 4 次；總和 = 2 + 4 = 6。

- Input: `s = "aeiaeia"` → Output: `3`  
  解釋：母音中最多 `'a'` 出現 3 次；沒有子音 → 子音頻率 = 0；總和 = 3 + 0 = 3。

---

## 解法概念

### 方法：計數 + 分類 + 最大值追蹤
1. 用長度 26 的陣列 `counts[26]` 或哈希表來計算每個字母在字串中出現的次數。  
2. 初始化兩個變數：
   - `maxVowel = 0`：母音的最大頻率  
   - `maxConsonant = 0`：子音的最大頻率  
3. 對所有字母 `c`：
   - 若 `c` 是母音 → 更新 `maxVowel = max(maxVowel, counts[c])`  
   - 否則 → 更新 `maxConsonant = max(maxConsonant, counts[c])`  
4. 回傳 `maxVowel + maxConsonant`

---

## 時間與空間複雜度
- **時間複雜度：** O(n + 26) ≒ O(n)，n 是字串長度  
- **空間複雜度：** O(1)，因為額外只用固定大小的陣列／哈希表（26 個字母）

---

## 關鍵重點
- 單次遍歷計數 + 再遍歷 26 個字母取最大值  
- 處理沒有母音或沒有子音的情況，要讓對應的最大頻率是 0  
- 母音集合硬寫好（例如 `"aeiou"` 或比對條件）比較方便