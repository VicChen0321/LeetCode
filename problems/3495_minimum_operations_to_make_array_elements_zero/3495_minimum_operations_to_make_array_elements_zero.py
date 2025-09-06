class Solution:
    def minOperations(self, queries: List[List[int]]) -> int:
        return sum((self.ops(r) - self.ops(l - 1) + 1) // 2 for l, r in queries)
    
    def ops(self, n: int) -> int:
        res, steps, base = 0, 0, 1
        while base <= n:
            steps += 1
            end = min (n, base * 4 - 1)
            res += (end - base + 1) * steps
            base *= 4
        return res