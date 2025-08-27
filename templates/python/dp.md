# DP / Memoization 模板

# Top-down (Fibonacci)
```python
def fib(n, memo={}):
    if n <= 1:
        return n
    if n not in memo:
        memo[n] = fib(n-1, memo) + fib(n-2, memo)
    return memo[n]
```

# Bottom-up
```python
dp = [0] * (n+1)
dp[0] = base_value
for i in range(1, n+1):
    dp[i] = some_relation
```