# 104 Maximum Depth of Binary Tree

**LeetCode Link:** [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
**Difficulty:** Easy
**Tags:** Tree, Depth-First Search, Breadth-First Search, Recursion

---

## 題目描述

給定一個二元樹，找出其 **最大深度**（root 到最遠葉節點的最長路徑長度）。

> 樹的深度定義為從根節點到最深葉節點的節點數。

---

### 範例

**Input**

```
root = [3,9,20,null,null,15,7]
```

**Output**

```
3
```

**Input**

```
root = [1,null,2]
```

**Output**

```
2
```

---

## 解法概念

### 方法一：遞迴 DFS

* 思路：

  1. 若節點為 `None` → 回傳 0
  2. 遞迴求左右子樹深度
  3. 最大深度 = max(左子樹深度, 右子樹深度) + 1
* Python 寫法：

```python
def maxDepth(root):
    if not root:
        return 0
    left_depth = maxDepth(root.left)
    right_depth = maxDepth(root.right)
    return max(left_depth, right_depth) + 1
```

### 方法二：迭代 BFS（層序遍歷）

* 使用 queue 進行層序遍歷
* 每遍歷一層，深度 +1
* Python 寫法：

```python
from collections import deque

def maxDepth(root):
    if not root:
        return 0
    queue = deque([root])
    depth = 0
    while queue:
        depth += 1
        for _ in range(len(queue)):
            node = queue.popleft()
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
    return depth
```

---

## 時間與空間複雜度

* **時間複雜度：** O(n) → 每個節點訪問一次
* **空間複雜度：**

  * 遞迴：O(h) → 遞迴棧，h = 樹高度
  * BFS：O(w) → 队列最大寬度 w

---

## 核心關鍵

* **遞迴 DFS** → 自然地求取左右子樹最大深度
* **迭代 BFS** → 按層遍歷，層數即深度
* 理解深度概念：從根到葉節點最長路徑
