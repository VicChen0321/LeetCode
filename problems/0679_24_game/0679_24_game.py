class Solution:
    EPSILON = 1e-6
    TARGET = 24.0
    def judgePoint24(self, cards: List[int]) -> bool:
        nums = [float(n) for n in cards]
        return self.dfs(nums)
    def dfs(self, nums: list[float]) -> bool:
        if len(nums) == 1:
            return abs(nums[0] - self.TARGET) < self.EPSILON
        n = len(nums)
        for i in range(n):
            for j in range(i + 1, n):
                a, b = nums[i], nums[j]
                for c in self.compute(a, b):
                    next_nums = [c] + [nums[k] for k in range(n) if k != i and k != j]
                    if self.dfs(next_nums):
                        return True
        return False
    
    def compute(self, a: float, b: float):
        res = [a + b, a - b, b - a, a * b]
        if abs(b) > self.EPSILON:
            res.append(a / b)
        if abs(a) > self.EPSILON:
            res.append(b / a)
        return res