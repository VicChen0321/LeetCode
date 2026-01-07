class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        total_sum = 0
        min_abs_val = float('inf')
        neg_count = 0

        for row in matrix:
            for val in row:
                if val < 0:
                    neg_count += 1
                    val = -val
                total_sum += val
                min_abs_val = min(min_abs_val, val)
        
        if neg_count % 2 != 0:
            total_sum -= 2 * min_abs_val
        
        return total_sum