# Graph 模板

# DFS 遞迴

```python
def dfs(graph, start, visited=set()):
    visited.add(start)
    for neigh in graph[start]:
        if neigh not in visited:
            dfs(graph, neigh, visited)
```

# BFS

```python
from collections import deque

def bfs(graph, start):
    visited = set()
    q = deque([start])
    visited.add(start)
    while q:
        node = q.popleft()
        for neigh in graph[node]:
            if neigh not in visited:
                visited.add(neigh)
                q.append(neigh)
```