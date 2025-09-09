# 2327 Number of People Aware of a Secret

**LeetCode Link:** [2327. Number of People Aware of a Secret](https://leetcode.com/problems/number-of-people-aware-of-a-secret/)  
**Difficulty:** Medium  
**Tags:** Dynamic Programming, Simulation, Queue

---

## 題目描述
- 第一天只有一個人知道一個秘密。
- 參數 `delay`：這個人需要等 `delay` 天後，每天分享給新的一個人。
- 參數 `forget`：這個人會在知道秘密的第 `forget` 天忘記它，不能分享。
- 給定 `n` 天後，問還有多少人知道這個秘密？答案需 **mod 10^9 + 7**。

---

## 解法概念

### 方法：滑動窗口 / DP
我們追蹤每天有多少新的人**知道**（`dp[i]`）這個秘密，並用一個累計 `share` 變數保存「今天可以分享的人數」。

1. 初始化：
   - `dp[0] = 1`：第1 天有 1 人知道
   - `share = 0`

2. 從第 2 天 (i = 1) 開始模擬到第 n 天：
   - 如果 `i - delay >= 0`，代表之前知道且已達分享期的人可以分享 → `share += dp[i - delay]`
   - 如果 `i - forget >= 0`，代表有人在今天忘記 → `share -= dp[i - forget]`
   - 做 modulo 操作確保 `share` 在範圍內
   - `dp[i] = share`

3. 最後，統計從 `n - forget + 1` 到 `n` 天的 `dp[i]`，這些人還記得秘密 → 加總後 mod 10^9+7。

---

## 時間與空間複雜度
- **時間複雜度：** O(n)
- **空間複雜度：** O(n)

---

## 關鍵重點
- `share` 表示當天能分享秘密的人數，累計窗口滑動更新。
- `dp[i]` = 知道秘密的人中「當天新加入」的人數。
- 結果需包含尚未忘記的人（最近 `forget` 天間加入）。