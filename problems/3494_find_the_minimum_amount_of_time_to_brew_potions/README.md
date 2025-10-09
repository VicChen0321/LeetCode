# 3494. Find the Minimum Amount of Time to Brew Potions

**LeetCode Link:** [3494. Find the Minimum Amount of Time to Brew Potions](https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/)  
**Difficulty:** Medium  
**Tags:** Array, Simulation, Greedy, Prefix Sum  

---

## 題目描述  

有 n 位巫師（wizard），有 m 個魔藥（potions）。巫師陣列 `skill[i]`，魔藥陣列 `mana[j]`。  

每個魔藥必須順序通過所有巫師處理：巫師 0 → 巫師 1 → … → 巫師 n-1，才算完成一瓶魔藥。  

處理方式：巫師 i 要花費時間 `skill[i] * mana[j]` 去釀造魔藥 j。  

**限制條件：**  
魔藥 j 的下一階段（給巫師 i+1）**必須在巫師 i 完成後立刻傳遞**，不能有等待或緩衝。  

求：釀造所有 m 瓶魔藥所需的最少總時間。  

---

## 正確思路 / 解法

### 核心觀察  
這題是流水線排程問題 (flow-shop)，但由於處理時間呈形如 `skill[i] * mana[j]`（可分解成 row × col），可以利用 prefix sum + 滾動模擬算出最優時間。

具體要點：

- 我們記 `sumSkill = sum(skill)`，代表所有巫師處理 **一單位魔藥** 所需的總時間比例因子。  
- 對於第一瓶魔藥 j=0，整條流水線從 wizard 0 → n-1 處理所需時間就是 `sumSkill * mana[0]`。  
- 對於接下來的每瓶魔藥 j（從 1 開始），我們要在前一瓶完成時間基礎上，考慮每個巫師因為上瓶魔藥、下瓶魔藥時間交錯、必須即刻傳遞的限制，調整最早可能開始的時間。  
- 我們用兩個滾動變數：
  - `prevWizardDone`：上一瓶魔藥整條流水線完成的時間  
  - `prevPotionDone`：用來在調整每個巫師時，減去該巫師所屬段的花費，得到上一階段可用時間窗  
- 從巫師索引 `i = n-2` 到 `i = 0`（反向）調整 `prevWizardDone`，確保「不能早於自己處理上一瓶魔藥的完成時間」與「不能早於前面巫師對本瓶魔藥的完成時間」這兩個約束都不被違反。  
- 最後把本瓶魔藥對整條流水線所需時間 `sumSkill * mana[j]` 加回 `prevWizardDone` 作為新的基礎。  
