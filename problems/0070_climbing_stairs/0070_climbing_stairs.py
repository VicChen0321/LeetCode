class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [1] * 2
        for i in range(2, n + 1):
            cur_dp = dp[0] + dp[1]
            dp[1], dp[0] = cur_dp, dp[1]
        return dp[1]