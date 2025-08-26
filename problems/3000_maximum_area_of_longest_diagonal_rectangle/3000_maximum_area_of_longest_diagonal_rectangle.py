class Solution:
    def areaOfMaxDiagonal(self, dimensions: List[List[int]]) -> int:
        max_diag, max_area = 0, 0
        for l, w in dimensions:
            diag = l**2 + w**2
            area = l * w
            if diag > max_diag:
                max_diag = diag
                max_area = area
            elif diag == max_diag:
                max_area = max(max_area, area)
        return max_area