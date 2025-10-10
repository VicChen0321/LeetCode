class Solution:
    def maximumEnergy(self, energy: List[int], k: int) -> int:
        n = len(energy)
        dp = energy[:]
        for i in range(n-1, -1, -1):
            if i + k < n:
                dp[i] += dp[i + k]
        return max(dp)