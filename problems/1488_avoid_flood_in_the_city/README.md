# 1488. Avoid Flood in The City

**LeetCode Link:** [1488. Avoid Flood in The City](https://leetcode.com/problems/avoid-flood-in-the-city/)  
**Difficulty:** Medium  
**Tags:** Greedy, Hash Table, Binary Search, Set / TreeSet

---

## 題目描述

有無限多個湖泊，最開始都是空的。給你一個整數陣列 `rains`，表示每天的天氣：

- 當 `rains[i] > 0`：那天會對第 `rains[i]` 號湖泊下雨，使其變滿。
- 當 `rains[i] == 0`：那天是晴天，你可以選擇 **乾一個湖泊**（把它變空）。

如果某天下雨到一個已經是滿的湖泊，會造成洪水。你要避免洪水發生。  
返回一個陣列 `ans`（與 `rains` 長度相同）：

- 當 `rains[i] > 0`（那天下雨）：`ans[i] = -1`
- 當 `rains[i] == 0`（晴天）：`ans[i] =` 你選擇乾的那個湖泊編號  
- 如果有多種合法答案，可返回任何一種；如果無法避免洪水，返回空陣列。

---

## 範例

- Input: `rains = [1,2,0,0,2,1]` → Output: `[-1,-1,2,1,-1,-1]`  
- Input: `rains = [1,2,0,1,2]` → Output: `[]`（無法避免洪水）

---

## 解法概念

### 方法：貪婪 + 記錄 + 有序結構 (TreeSet / SortedList)

1. 用 `lastRain` map：`lake → 最後一次下雨的日子`  
2. 用集合 `dryDays`（有序集合）記晴天的索引  
3. 建立 `ans` 陣列，初始全部填 `-1`  
4. 走訪 `rains`：
   - 若 `rains[i] > 0`（下雨到湖泊 `lake`）：
     - 若該 `lake` 在 `lastRain` 中已有紀錄（表示之前已滿）：
       - 要從 `dryDays` 裡找一個晴天 `d`，使得 `d > lastRain[lake]`（在它上次下雨後選天去乾它）  
       - 如果找不到 → 洪水發生 → 回傳空陣列  
       - 否則：`ans[d] = lake`，從 `dryDays` 移除那天  
     - 更新 `lastRain[lake] = i`
   - 若 `rains[i] == 0`（晴天）：  
     - 加入 `dryDays`（可用這天乾湖泊）  
     - 暫設 `ans[i] = 1`（可乾任意，後續可能被 overwrite）

---

## 時間與空間複雜度

- **時間複雜度：** O(n log n)（每晴天加入組合 O(log n)，每次查找下一個乾天也 O(log n)
- **空間複雜度：** O(n)（`lastRain` map + `dryDays` 結構 + `ans` 陣列


class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        TreeSet<Integer> dryDays = new TreeSet<>();
        Map<Integer, Integer> lastRain = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                if (lastRain.containsKey(lake)) {
                    Integer d = dryDays.higher(lastRain.get(lake));
                    if (d == null) {
                        return new int[0];
                    }
                    ans[d] = lake;
                    dryDays.remove(d);
                }
                lastRain.put(lake, i);
            } else {
                dryDays.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}