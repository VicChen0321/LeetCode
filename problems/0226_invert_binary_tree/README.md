# 226 Invert Binary Tree

**LeetCode Link:** [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)
**Difficulty:** Easy
**Tags:** Tree, Depth-First Search, Recursion, Breadth-First Search

---

## 題目描述

給定一個二元樹，將其 **左右子樹翻轉**，即將每個節點的左子樹與右子樹互換。

---

### 範例

**Input**

```
root = [4,2,7,1,3,6,9]
```

**Output**

```
[4,7,2,9,6,3,1]
```

**Input**

```
root = [2,1,3]
```

**Output**

```
[2,3,1]
```

**Input**

```
root = []
```

**Output**

```
[]
```

---

## 解法概念

### 方法一：遞迴 DFS

* 思路：

  1. 若節點為 `None` → 回傳 `None`
  2. 遞迴翻轉左右子樹
  3. 將節點的左右子樹交換
* Python 寫法：

```python
def invertTree(root):
    if not root:
        return None
    # 遞迴翻轉左右子樹
    left = invertTree(root.left)
    right = invertTree(root.right)
    # 交換
    root.left, root.right = right, left
    return root
```

### 方法二：迭代 BFS / DFS

* 使用 queue 或 stack 進行層序或前序遍歷
* 遍歷過程中交換每個節點的左右子樹
* Python BFS 寫法：

```python
from collections import deque

def invertTree(root):
    if not root:
        return None
    queue = deque([root])
    while queue:
        node = queue.popleft()
        node.left, node.right = node.right, node.left
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
    return root
```

---

## 時間與空間複雜度

* **時間複雜度：** O(n) → 每個節點訪問一次
* **空間複雜度：**

  * 遞迴：O(h) → 遞迴棧，h = 樹高度
  * BFS：O(w) → 队列最大寬度 w

---

## 核心關鍵

* 對每個節點，**交換左右子樹**
* 遞迴 DFS 直覺簡潔
* 迭代 BFS 適合避免過深遞迴棧或需要層序操作
* 翻轉二元樹是一個典型 **Tree DFS 練習題**
