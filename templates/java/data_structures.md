# 🧠 資料結構常用初始化 (Data Structures)
```java
// HashMap / TreeMap
Map<String, Integer> map = new HashMap<>();
Map<String, Integer> treeMap = new TreeMap<>();

// Set
Set<Integer> set = new HashSet<>();

// Queue / Deque
Queue<Integer> q = new LinkedList<>();
Deque<Integer> dq = new ArrayDeque<>();

// PriorityQueue (小根堆 / 大根堆)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

// Stack
Stack<Integer> stack = new Stack<>();

// Pair-like structure
record Pair(int x, int y) {}
```