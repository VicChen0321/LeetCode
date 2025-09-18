# 3408 Design Task Manager

**LeetCode Link:** [3408. Design Task Manager](https://leetcode.com/problems/design-task-manager/)  
**Difficulty:** Medium  
**Tags:** Design, Hash Table, TreeSet / Priority Queue

---

## 題目描述
設計一個任務管理系統 `TaskManager`，支援以下操作：

- `TaskManager(tasks)`：初始化，有一組 `[userId, taskId, priority]` 的任務清單加入系統。  
- `add(userId, taskId, priority)`：新增任務（保證 `taskId` 是新的）。  
- `edit(taskId, newPriority)`：修改現有任務的優先權（保證存在）。  
- `rmv(taskId)`：移除一個任務（保證存在）。  
- `execTop()`：執行並移出目前系統中 **優先權最高** 的任務，若有多個優先權相同，執行 `taskId` 最大的那個。執行後回傳該任務的 `userId`；若無任務則回傳 `-1`。

---

## 解法概念

### 方法：Hash Map + 有序資料結構 (TreeSet or SortedList or PriorityQueue + lazy deletion)

1. 用一個 Map `d` 儲存 `taskId -> (userId, priority)`，方便查 priority/userId。  
2. 用一個有序集合（可以是 TreeSet、SortedList、或 PriorityQueue + lazy deletion）維護所有任務，排序準則為：
   - 優先權 (priority) 降序
   - 若優先權相同，`taskId` 降序

3. 每個操作：
   - `add`：把新的 `(priority, taskId)` 加進有序集合 + 更新 Map。  
   - `edit`：從有序集合中移除舊的 `(oldPriority, taskId)`，更新 Map，再插入新的。  
   - `rmv`：從 Map 拿到 priority，從有序集合移除這個項目 + 刪除 Map。  
   - `execTop`：若集合非空，取第一個元素，從集合和 Map 都移除，回傳 userId；若空回 -1。

---

## 時間與空間複雜度
- **時間複雜度：**  
  - 初始化：O(n log n)  
  - 每次 `add` / `edit` / `rmv` / `execTop` 約 O(log n)  
- **空間複雜度：** O(n) —— 存 Map + 有序集合