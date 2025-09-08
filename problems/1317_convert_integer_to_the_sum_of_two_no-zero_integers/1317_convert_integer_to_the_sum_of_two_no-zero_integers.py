class Solution:
    def getNoZeroIntegers(self, n: int) -> List[int]:
        def has_zero(x):
            while x > 0:
                if x % 10 == 0:
                    return True
                x //= 10
            return False
        
        for i in range(1, n):
            if not has_zero(i) and not has_zero(n - i):
                return [i, n - i]
        return [-1, -1]