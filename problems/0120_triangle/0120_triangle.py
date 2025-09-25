class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        dp = [0] * (len(triangle) + 1)
        for row in triangle[::-1]:
            for col, n in enumerate(row):
              dp[col] = min(dp[col], dp[col + 1]) + n
        return dp[0]