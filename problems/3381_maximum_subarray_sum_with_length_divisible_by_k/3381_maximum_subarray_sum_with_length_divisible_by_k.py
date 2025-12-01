class Solution:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        min_prefix = [float('inf')] * k
        min_prefix[k - 1] = 0
        s = 0
        ans = float('-inf')
        for i, x in enumerate(nums):
            s += x
            r = i % k
            ans = max(ans, s - min_prefix[r])
            min_prefix[r] = min(min_prefix[r], s)
        return ans