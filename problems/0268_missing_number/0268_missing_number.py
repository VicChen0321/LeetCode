class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n, s = len(nums), sum(nums)
        return n * (n + 1) // 2 - s