# 3484. Design Spreadsheet

**LeetCode Link:** [3484. Design Spreadsheet](https://leetcode.com/problems/design-spreadsheet/)  
**Difficulty:** Medium  
**Tags:** Design, Hash Table, String Parsing, Simulation

---

## 題目描述
設計一個簡單的電子試算表（spreadsheet），共有 **26 欄 (A–Z)** 與 `rows` 行，每個格子初始值為 `0`。需要支援以下操作：

- **初始化**：  
  `Spreadsheet(int rows)` 建立一個 `26 x rows` 的表格，所有格子初始為 `0`。

- **setCell(cell, value)**：設定指定 cell 的值，例如 `"A1" = 5`。

- **resetCell(cell)**：把指定 cell 的值重設為 `0`。

- **getValue(formula)**：計算並回傳公式的結果。  
  公式格式固定為 `=X+Y`，其中 `X` 與 `Y` 要嘛是整數，要嘛是 cell 名稱（若該 cell 未設定過則視為 `0`）。

---

## 解法概念

### 方法：HashMap + 字串解析
1. **資料結構設計**
   - `map`: `cellName -> value`  
     僅儲存被設定過的 cell，其餘預設為 `0`。

2. **操作流程**
   - `setCell`：直接更新 `map[cell] = value`。  
   - `resetCell`：刪除該 key（若不存在則無事發生）。  
   - `getValue`：解析公式字串，去掉 `=`，拆成 `X` 和 `Y`，逐一判斷：
     - 若是數字 → 轉為 int。  
     - 若是 cell 名稱 → 從 `map` 取值，若不存在回傳 `0`。  
   - 回傳兩者加總。

---

## 時間與空間複雜度
- **setCell:** O(1)  
- **resetCell:** O(1)  
- **getValue:** O(1)（字串處理 + 查表）  
- **空間:** O(k)，k 為被設定過的 cell 數量

---

## 關鍵重點
- 題目保證公式格式固定為 `=X+Y`，只需解析兩個 operand。  
- 未設定過的 cell 視為 `0`，可用 `map.getOrDefault(cell, 0)` 取得。  
- `resetCell` 建議直接刪除 key，避免與 `0` 混淆。  
- 如果題目延伸為更複雜公式（如範圍、SUM、鏈式依賴），就需要圖結構與依賴追蹤，但本題只需簡單處理。
