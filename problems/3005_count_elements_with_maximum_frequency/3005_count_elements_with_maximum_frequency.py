class Solution:
    def maxFrequencyElements(self, nums: list[int]) -> int:
        freq = Counter(nums)
        maxFreq = max(freq.values())
        return sum(count for count in freq.values() if count == maxFreq)
