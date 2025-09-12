# 3227 Vowels Game in a String

**LeetCode Link:** [3227. Vowels Game in a String](https://leetcode.com/problems/vowels-game-in-a-string/)  
**Difficulty:** Medium  
**Tags:** String, Game Theory, Greedy

---

## 題目描述

給定字串 s，兩個玩家 Alice 與 Bob 輪流進行遊戲，Alice 先手：

- Alice 的操作：刪除任意一個含**奇數個母音**的非空子字串
- Bob 的操作：刪除任意一個含**偶數個母音**的非空子字串
- 若輪到某人時無法進行操作，該玩家輸掉遊戲

兩人都採取最優策略。請判斷誰會贏。

---

## 解法概念

### 核心思路

1. 遊戲的核心在於字串中**母音的數量**：
   - 若 `s` 中至少有**一個母音**，Alice 可以在第一步刪掉它（這是一個奇數母音子字串）。
   - 此時 Bob 的選擇受到限制，通常無法立即扳回劣勢。
   - 因此 Alice 有必勝策略。
2. 若 `s` 中 沒有母音，Alice 一開始就無法進行操作，直接輸。

**結論**
- 若 s 含有至少一個母音 → Alice 贏
- 若 s 沒有母音 → Bob 贏

---

## 時間與空間複雜度
- **時間複雜度:** O(n)，遍歷字串一次統計母音  
- **空間複雜度:** O(1)，僅需計數器
