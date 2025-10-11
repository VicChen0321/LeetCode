class Solution:
    def maximumTotalDamage(self, power: List[int]) -> int:
        cnt = Counter(power)
        nums = sorted(cnt)
        n = len(nums)
        dp = [0] * (n + 1)

        # Presum for each damage
        total = [nums[i] * cnt[nums[i]] for i in range(n)]
        
        for i in range(n):
            j = i - 1
            while j >= 0 and nums[j] >= nums[i] - 2:
                j -= 1
            pick = total[i] + (dp[j + 1] if j >= 0 else 0)
            dp[i + 1] = max(dp[i], pick)
        return dp[n]