# 1792 Maximum Average Pass Ratio

**LeetCode Link:** [1792. Maximum Average Pass Ratio](https://leetcode.com/problems/maximum-average-pass-ratio/)  
**Difficulty:** Medium  
**Tags:** Array, Greedy, Heap (Priority Queue)

---

## 題目描述
你有多個班級，每個班級由一個二元素陣列表示 `[pass_i, total_i]`：
- `pass_i`: 班級中已保證通過考試的學生數量  
- `total_i`: 班級的總學生數  

給你一個 `extraStudents`，代表額外有這麼多表現優異的學生，他們加入任何班級都必定通過。目標是分配這些學生到各班，最大化所有班級平均通過率（每個班通過率為 `pass/total`）。

返回 **最大可能的平均通過率**，答案與正確值誤差在 `1e-5` 以內即可通過。

---

## 解法概念

### 方法：貪心 + 最大堆（Greedy + Max-Heap）

**核心思路：**
- 每次都將一位 extra student 加到最能提升通過率的班級。
- 提升多少？計算額外學生加入前後的通過率差：`gain = (pass + 1)/(total + 1) - pass/total`
- 使用最大堆來高效選出當前增益最大的那個班級，放入一位學生後更新再推回堆裡。

---

## 核心關鍵
- 採用 **貪心策略**：每次挑增益最大的班級加學生，效率最佳。
- 使用 heap（priority queue）實現高效選擇。
- `gain` 隨著學生加入會逐漸遞減，所以這種做法正確。