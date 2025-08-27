# Binary Tree 模板

```python
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
```

### DFS 遞迴

```python
def dfs(root):
    if not root:
        return
    dfs(root.left)
    dfs(root.right)
```

### BFS

```python
from collections import deque
def bfs(root):
    if not root:
        return
    q = deque([root])
    while q:
        node = q.popleft()
        if node.left: q.append(node.left)
        if node.right: q.append(node.right)
```