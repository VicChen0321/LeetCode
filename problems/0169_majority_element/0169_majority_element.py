class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        candidate, cnt = None, 0
        
        for num in nums:
            if cnt == 0:
                candidate = num
            cnt += 1 if candidate == num else -1

        return candidate