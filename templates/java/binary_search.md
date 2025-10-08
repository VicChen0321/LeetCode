# 🔍 Binary Search 樣板

## 模式一：找第一個 >= target 位置

```java
int l = 0, r = n; // [0, n)
while (l < r) {
    int mid = l + (r - l) / 2; // 避免溢位
    if (arr[mid] >= target)
        r = mid;        // mid 可能是答案，右縮
    else
        l = mid + 1;    // mid 太小，往右找
}
return l; // 若都小於 target，返回 n

```

## 模式二：找最後一個 <= target 位置

```java
int l = 0, r = n; // [0, n)
while (l < r) {
    int mid = l + (r - l) / 2; // 避免溢位
    if (arr[mid] <= target)
        l = mid + 1;  // mid 符合條件，左縮往右找更大的
    else
        r = mid;      // mid 太大，收縮右邊界
}
return l - 1; // 若都比 target 大，返回 -1

```
