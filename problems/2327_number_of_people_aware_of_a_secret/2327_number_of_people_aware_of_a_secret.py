class Solution:
    def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
        MOD = 10**9 + 7
        dp = [0] * n
        dp[0] = 1
        share = 0
        for i in range(1, n):
            if i >= delay:
                share = (share + dp[i - delay] + MOD) % MOD
            if i >= forget:
                share = (share - dp[i - forget] + MOD) % MOD
            dp[i] = share
        return sum (dp[n - forget:]) % MOD