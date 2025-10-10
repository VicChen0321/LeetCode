# 3147 Taking Maximum Energy From the Mystic Dungeon

**LeetCode Link:** [3147. Taking Maximum Energy From the Mystic Dungeon](https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/)  
**Difficulty:** Medium  
**Tags:** Array, Dynamic Programming, Simulation

---

## 題目描述
在一個神秘地牢中，`n` 位魔法師排成一列。每位魔法師都有一個能量值（可能為負），表示你和他互動時獲得或失去的能量。

**詛咒規則**如下：

- 你每吸收完第 `i` 位魔法師的能量後，會被「瞬間傳送」到編號為 `(i + k)` 的魔法師。
- 這一傳送規則會一直重複，直到跳出去為止（即 `(i + k)` 超出陣列範圍）。
- 請你**選擇一個起始位置**，經過上述規則，一路吸收經過的魔法師能量，問你**最多能獲得多少能量**。

- 必須吸收遇到魔法師的能量（不可略過即使是負數）。

### 範例

- Input: `energy = [5,2,-10,-5,1]`, `k = 3`  
  Output: `3`  
  解釋：  
  - 從 index 1（能量 `2`）開始，2 →（跳k=3格）1，總和是 `2+1=3`
- Input: `energy = [-2,-3,-1]`, `k = 2`  
  Output: `-1`  
  解釋：從 index 2 開始結果最大

---

## 解法概念

### 方法：Dynamic Programming + 最大後綴和
- 觀察每一種起跳方式會產生 `k` 組互不重疊的算術「遞增序列」。
- 設 dp[i] ：表示從位置 i 出發後能取得的最大能量。
    - 狀態遞推式：`dp[i] = energy[i] + (i + k < n ? dp[i + k] : 0)`
- 因為每次只會加上往後的同一跳距，所以可以「逆推」填 dp，或直接求後綴最大和。

#### 實作步驟

1. 初始化 dp[i] = energy[i]
2. 倒序遍歷每個 `i = n-1 → 0`，若 `i + k < n`，則 `dp[i] += dp[i + k]`
3. 最後答案為所有 dp[i] 值的最大值

---

## 時間與空間複雜度

- **時間複雜度：** O(n)  
  - 每個位置最多計算一次。
- **空間複雜度：** O(n)  
  - 需維護一個長度為 n 的 dp 陣列儲存最大能量。