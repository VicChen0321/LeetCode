class Solution:
    def maxRunTime(self, n: int, batteries: List[int]) -> int:
        left, right = 1, sum(batteries)
        ans = 0
        while left <= right:
            mid = (left + right) // 2
            if n * mid <= sum(min(b, mid) for b in batteries):
                ans = mid
                left = mid + 1
            else:
                right = mid - 1
        return ans
