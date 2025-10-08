# 🧾 字串操作 (String Handling)

```java
// 分割字串
String[] parts = s.split("\\.");

// 轉大小寫
s = s.toLowerCase();
s = s.toUpperCase();

// 反轉字串
String reversed = new StringBuilder(s).reverse().toString();

// 判斷開頭結尾
if (s.startsWith("ab") || s.endsWith("cd")) { ... }

// 移除空白
s = s.trim();
```