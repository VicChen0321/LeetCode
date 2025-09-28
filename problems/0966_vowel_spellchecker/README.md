# 966 Vowel Spellchecker

**LeetCode Link:** [966. Vowel Spellchecker](https://leetcode.com/problems/vowel-spellchecker/)  
**Difficulty:** Medium  
**Tags:** Hash Table, String

---

## 題目描述
給定一個字典 `wordlist` 和一組查詢字串 `queries`。  

需要根據以下規則，找到查詢對應的字典單詞，返回結果陣列：  

1. **完全匹配（Case-sensitive exact match）**  
   - 如果查詢字串在字典中出現過（大小寫完全相同），返回該字串。  

2. **大小寫不敏感匹配（Case-insensitive match）**  
   - 如果查詢字串僅大小寫不同，但忽略大小寫後相同，則返回字典中第一個匹配的單詞。  

3. **母音模糊匹配（Vowel error match）**  
   - 如果將查詢字串中的所有母音（a, e, i, o, u）替換成相同的字元（例如 `*`），  
     且忽略大小寫後，字典中存在相同的轉換字串，則返回第一個匹配的單詞。  

4. **若都不符合** → 返回空字串 `""`。

---

## 解法概念

### 方法：HashMap + String Normalization
1. **建立三個映射表**
   - `exactSet`: 原字典集合，用於完全匹配。  
   - `caseMap`: 大小寫不敏感對應（key = lowercase word, value = 第一個出現的 word）。  
   - `vowelMap`: 母音模糊對應（key = lowercase 並將母音轉成 `*`，value = 第一個出現的 word）。  

2. **處理每個 query**
   - 若 exact 匹配 → 直接返回。  
   - 若 lowercase 匹配 → 返回對應字典單詞。  
   - 若 vowel 替換後匹配 → 返回對應字典單詞。  
   - 否則返回 `""`。  

---

## 時間與空間複雜度
- **時間複雜度：** O(n + m)
    - n = wordlist 長度，m = queries 長度
    - 建立映射與查詢都在常數時間內完成
- **空間複雜度：** O(n)
    - HashSet 與 HashMap 存儲字典單詞

---

## 關鍵重點
- 要依序檢查三種匹配規則（exact → case-insensitive → vowel）
- vowel normalization：將母音統一替換成 `*`，方便比較
- `putIfAbsent` / `setdefault` 確保取到 字典中第一個匹配