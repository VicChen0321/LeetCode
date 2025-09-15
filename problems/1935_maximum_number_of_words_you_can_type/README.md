# 1935 Maximum Number of Words You Can Type

**LeetCode Link:** [1935. Maximum Number of Words You Can Type](https://leetcode.com/problems/maximum-number-of-words-you-can-type/)  
**Difficulty:** Easy  
**Tags:** String, Hash Set

---

## 題目描述
給定一段文字 `text`（由空格分隔的單詞）以及一個字串 `brokenLetters`，其中每個字母代表一個「壞掉」的鍵盤按鍵。  

你需要計算：在輸入文字 `text` 時，最多能正確打出多少個完整的單詞。  
若單詞中包含任一壞掉字母，該單詞就無法完整輸入。  

---

## 範例

**Example 1:**
```
Input: text = "hello world", brokenLetters = "ad"
Output: 1
Explanation: "world" 可以輸入，但 "hello" 有 'a' 鍵損壞 → 無法輸入。
```

**Example 2:**
```
Input: text = "leet code", brokenLetters = "lt"
Output: 1
Explanation: "leet" 包含 'l'，"code" 可以輸入 → 只能打出 1 個。
```

**Example 3:**
```
Input: text = "leet code", brokenLetters = "e"
Output: 0
Explanation: 兩個單詞都包含 'e' → 全部都打不出來。
```


---

## 解法概念

### 方法：Hash Set + 遍歷
1. 將 `brokenLetters` 轉成一個集合 `broken`，方便快速檢查是否有壞字母。  
2. 將 `text` 依空格切開成單詞。  
3. 對於每個單詞，檢查是否含有 `broken` 中的字母：  
   - 若無 → 計數器加一。  
   - 若有 → 跳過。  

> Java Hash Set 可以用 boolean[26] 替代去加速