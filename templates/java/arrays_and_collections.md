# 🔢 陣列與集合處理 (Arrays & Collections)
```java
// 陣列排序
Arrays.sort(arr);

// 反轉陣列
Collections.reverse(list);

// 尋找最大值最小值
int max = Arrays.stream(arr).max().getAsInt();
int min = Arrays.stream(arr).min().getAsInt();

// 累加總和
int sum = Arrays.stream(arr).sum();

// 計算平均
double avg = Arrays.stream(arr).average().orElse(0);

// 複製陣列
int[] copy = Arrays.copyOf(arr, arr.length);

// 初始化 2D 陣列
int[][] grid = new int[n][m];
```