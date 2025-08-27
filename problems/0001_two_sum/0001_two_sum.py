class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_map = {}
        for i, num in enumerate(nums):
            pair = target - num
            if pair in num_map:
                return [num_map[pair], i]
            num_map[num] = i
        return []