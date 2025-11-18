# 121 Best Time to Buy and Sell Stock

**LeetCode Link:** [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
**Difficulty:** Easy
**Tags:** Array, Dynamic Programming

---

## 題目描述

給定一個整數陣列 `prices`，其中 `prices[i]` 是某支股票第 `i` 天的價格。

你最多只能進行 **一次交易**（買入一次且賣出一次），請找出能獲得的最大利潤。

> 注意：必須先買入後賣出，不能先賣出再買入。

---

### 範例

**Input**

```
prices = [7,1,5,3,6,4]
```

**Output**

```
5
```

**Explanation:** 在第 2 天買入（price = 1），第 5 天賣出（price = 6），最大利潤 = 6 - 1 = 5。

**Input**

```
prices = [7,6,4,3,1]
```

**Output**

```
0
```

**Explanation:** 股票價格不升，無法獲利，最大利潤 = 0。

---

## 解法概念

### 方法一：一次遍歷（One Pass）

* 思路：

  1. 記錄目前看到的 **最低價格** `min_price`
  2. 每遇到一天，計算以當天價格賣出的潛在利潤 `profit = price - min_price`
  3. 更新最大利潤 `max_profit`
* 代碼示意（Python）：

```python
def maxProfit(prices):
    min_price = float('inf')
    max_profit = 0
    for price in prices:
        min_price = min(min_price, price)
        max_profit = max(max_profit, price - min_price)
    return max_profit
```

### 方法二：動態規劃（DP）

* 定義狀態：

  * `dp[i][0]` → 第 i 天手上不持股的最大利潤
  * `dp[i][1]` → 第 i 天手上持股的最大利潤
* 狀態轉移：

  ```
  dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
  dp[i][1] = max(dp[i-1][1], -prices[i])
  ```

* 初始狀態：

  ```
  dp[0][0] = 0
  dp[0][1] = -prices[0]
  ```

* 取 `dp[-1][0]` 為答案

---

## 時間與空間複雜度

* **時間複雜度：** O(n) → 單次掃描價格陣列
* **空間複雜度：** O(1) → 只需記錄 min_price 與 max_profit，或用滾動變數優化 DP
