class Solution:
    def occurrencesOfElement(self, nums: List[int], queries: List[int], x: int) -> List[int]:
        indices = [i for i, val in enumerate(nums) if val == x]
        ans = []
        for q in queries:
            if q <= len(indices):
                ans.append(indices[q - 1])
            else:
                ans.append(-1)
        return ans