class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        max_prod, min_prod, res = nums[0], nums[0], nums[0]
        for num in nums[1:]:
            if num < 0:
                max_prod, min_prod = min_prod, max_prod
            max_prod = max(num, num * max_prod)
            min_prod = min(num, num * min_prod)
            res = max(res, max_prod)
        return res