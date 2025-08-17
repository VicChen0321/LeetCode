# 837 New 21 Game

**LeetCode Link:** [837. New 21 Game](https://leetcode.com/problems/new-21-game/)  
**Difficulty:** Medium  
**Tags:** Dynamic Programming, Probability, Sliding Window

---

## 題目描述
Alice 從 0 分開始，每次隨機抽一個整數，範圍為 `[1, maxPts]`。她持續抽牌，直到 **總分 >= k** 則停止抽牌。  

遊戲結束時，如果她的分數 **不超過 n**，她就贏了。  
求 Alice 贏的機率。

- 範例 1：
  - Input: `n = 10, k = 1, maxPts = 10`
  - Output: `1.0`

- 範例 2：
  - Input: `n = 6, k = 1, maxPts = 10`
  - Output: `0.6`

- 範例 3：
  - Input: `n = 21, k = 17, maxPts = 10`
  - Output: `0.73278`

Constraints:
- 0 ≤ k ≤ n ≤ 10⁴
- 1 ≤ maxPts ≤ 10⁴
- 答案誤差在 10⁻⁵ 內都視為正確

---

## 解法概念

### 動態規劃 + 滑動窗口
- 定義 `dp[x] = 從分數 x 開始贏的機率`。  
- 遞推式：
  - 如果 `x >= K`，遊戲結束，贏的機率 = `1.0` 若 `x <= N`，否則 `0.0`。  
  - 如果 `x < K`，則：
    ```
    dp[x] = (dp[x+1] + dp[x+2] + ... + dp[x+W]) / W
    ```
- 直接計算會 O(NW)，太慢。  
- 優化：用一個 windowSum 去維護這個區間和
  - 移入：windowSum += dp[x]
  - 移出：windowSum -= dp[x - w]
