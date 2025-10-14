class Solution:
    def hasIncreasingSubarrays(self, nums: List[int], k: int) -> bool:
        incr = 1
        pre = 0
        n = len(nums)

        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                incr += 1
            else:
                pre = incr
                incr = 1
            # 檢查條件
            if incr // 2 >= k or min(pre, incr) >= k:
                return True
        return False