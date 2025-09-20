# 3508 Implement Router

**LeetCode Link:** [3508. Implement Router](https://leetcode.com/problems/implement-router/)  
**Difficulty:** Medium  
**Tags:** Queue, Hash Table, Binary Search, Design

---

## 題目描述
設計一個 Router 結構管理資料封包。每個封包包含三個屬性：`source`, `destination`, `timestamp`。  
實作以下 API：

- `Router(int memoryLimit)`：初始化路由器，最多能同時儲存 `memoryLimit` 個封包（FIFO）。
- `boolean addPacket(int source, int destination, int timestamp)`：嘗試加入一個封包：
  - 若該 `(source,destination,timestamp)` 已存在 → 返回 `false`（視為重複，不加入）。
  - 若路由器已滿 → 先 `forwardPacket()`（彈出最舊封包）再加入。
  - 成功加入返回 `true`。
- `List<Integer> forwardPacket()`：把最早的封包從路由器彈出並回傳 `[source, destination, timestamp]`；若空則回 `[]`。
- `int getCount(int destination, int startTime, int endTime)`：查詢目前路由器中，指定 `destination` 的封包 timestamp 在 `[startTime, endTime]` 的數量（包含端點）。

額外條件與限制：
- `addPacket` 的呼叫會以**非遞減**的 `timestamp` 順序到來（可相等）。
- 呼叫次數與 memoryLimit 上界約 1e5（需注意效率）。

---

## 解法概念（核心）
> 目的：維持 FIFO 行為（forward 最舊），同時能對每個 destination 做時間區間數量查詢（快）。

### 用到的資料結構
1. 全局 FIFO queue（Deque）→ 儲存封包順序，用於 `forwardPacket()` 與在滿時刪最舊封包。  
2. `seen` 集合（HashSet）→ 去重 `(source,destination,timestamp)`。  
3. `dest -> timestamps list`（HashMap 到 list）→ 每個 destination 的 timestamp 陣列（因 addPacket 的 timestamp 是非遞減，對應 list 永遠是已排序的，支援二分搜尋）。  
4. `processedIndex`（HashMap int）→ 每個 destination 在該 list 的「起始有效索引」，當舊封包被 forward 掉時只需把該 destination 的指標 +1（避免在 list 前端頻繁刪除造成 O(n) 開銷）。

### 各操作細節
- `addPacket`：
  - 檢查 `seen`：重複就 `false`。
  - 若 queue 已滿，先 `forwardPacket()` 一個（釋放一個 slot）。
  - push 到 queue、加入 `seen`、在 `dest` 的 timestamp list `append(timestamp)`。
- `forwardPacket`：
  - pop queue 左側（最舊），從 `seen` 抹掉，對該 destination 做 `processedIndex[destination] += 1`，回傳 popped 封包資料。
- `getCount`：
  - 取出 `dest` 的 timestamp list 與起始 index `left`，在 `[left, len)` 範圍用 `bisect_left`/`bisect_right` 做二分查詢找出落在 `[startTime, endTime]` 的數量 → `O(log m)`。

---

## 複雜度
- `Router()`：O(1)
- `addPacket`：O(1) 平均（append 與 set/queue 操作）
- `forwardPacket`：O(1)
- `getCount`：O(log m)（m = 該 destination 的封包數） — 使用二分搜尋
- 空間：O(total added packets)（包含 queue, seen, 所有 destination lists）

---

## 關鍵注意點
- **timestamps 對每個 destination 是單調非減**，因此 per-destination 使用 append 保持排序，才能用二分查詢。
- 刪除最舊封包時避免在 list 頭 remove（O(n)）；改用 per-destination 的 `processedIndex`（左指標）配合 binary search 的 `lo` 參數。
- `seen` 的 key 必須包含三個欄位（source,destination,timestamp）且 hash/equals 要正確，防止重複計數。
- 當 queue 為 full 時，`addPacket` 會自動呼叫一次 `forwardPacket()`（題目要求的行為）。
