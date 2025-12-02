class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        max_len = 0
        for num in num_set:
            if num - 1 not in num_set:  # 序列開頭
                current = num
                length = 1
                while current + 1 in num_set:
                    current += 1
                    length += 1
                max_len = max(max_len, length)
        return max_len
