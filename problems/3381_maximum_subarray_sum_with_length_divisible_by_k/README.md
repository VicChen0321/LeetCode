# 3381 Maximum Subarray Sum With Length Divisible by K

**LeetCode Link:**
[3381. Maximum Subarray Sum With Length Divisible by K](https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/) ([LeetCode][1])

**Difficulty:** Medium
**Tags:** Array, Prefix Sum, Modulo, Hash / DP

---

## 題目描述

給定一個整數陣列 `nums` 和一個整數 `k`。
請找出一個 **連續子陣列 (subarray)**，使得：

* 該子陣列的 **長度是 k 的倍數**（`length % k == 0`）
* 同時使子陣列的 **總和最大**

回傳這個最大可能的子陣列和。子陣列必須 **非空**。 ([Leetcode][2])

---

### 範例

**Input**

```
nums = [1,2], k = 1
```

**Output**

```
3
```

**解釋**
子陣列 [1,2] 長度為 2，是 1 的倍數，總和 = 3。 ([Leetcode][2])

**Input**

```
nums = [-1,-2,-3,-4,-5], k = 4
```

**Output**

```
-10
```

**解釋**
可以選子陣列 [-1,-2,-3,-4]（長度 4，是 4 的倍數），和為 -10，是所有合法子陣列中最大（因為全負） 。 ([Leetcode][2])

**Input**

```
nums = [-5,1,2,-3,4], k = 2
```

**Output**

```
4
```

**解釋**
合法子陣列例如 [1,2,-3,4]（長度 4，是 2 的倍數），總和 = 4，是最大。 ([Leetcode][2])

---

## 解法概念

### 方法：Prefix Sum + 模 (modulo) 分類 + 最小前綴和追蹤

關鍵洞察：

* 子陣列 `nums[i..j]` 的長度為 `(j - i + 1)`。若要 `length % k == 0`，等價於 `(j % k) == ((i - 1) % k)`。
* 若我們能記錄到目前為止，各種 `index mod k` 之下的**最小 prefix sum**，則對於當前 index `i`，我們可以算出從某個之前 `j+1` 到 `i` 的子陣列是否有最大和，同時長度滿足倍數條件。

具體步驟：

1. 計算 prefix sum `s[i] = nums[0] + ... + nums[i]`。
2. 維護一個長度為 `k` 的陣列 `minPrefix[r]`，其中 `r = i % k`，代表目前看到過的 prefix sums 中，對應 remainder `r` 的**最小值**。
3. 每遍歷到 `i`，更新答案為 `max(ans, s[i] - minPrefix[i % k])`。
4. 然後更新 `minPrefix[i % k] = min(minPrefix[i % k], s[i])`。

這樣對每個 `i` 都在 O(1) 操作就判斷了「以 `i` 為終點」且長度符合條件的子陣列最大和。 ([AlgoMonster][3])

---

## 時間與空間複雜度

| 項目        | 複雜度                             |
| --------- | ------------------------------- |
| **時間複雜度** | O(n) — 遍歷一次陣列                   |
| **空間複雜度** | O(k) — 用額外大小為 k 的陣列儲存 minPrefix |

---

## 核心關鍵

* 使用 **prefix sum + mod k 分類** 的技巧，把「長度是 k 的倍數」的條件轉換成 index mod 應該一致
* 維護對每種 remainder 的 **最小 prefix sum**，確保 subarray 長度與 sum 都合條件
* 在遍歷中即時計算 max sum，避免 O(n²) 的暴力檢查

## 注意事項 / Edge Cases

* 當 `nums` 全為負數、或有很大負值時，也應能正確回傳最大（可能是負值）子陣列和。
* `k` 可為 1（即任何長度都合法），也必須正確處理。
* prefix sum、minPrefix 的型別要足夠大，以免溢位（Java 用 long）
