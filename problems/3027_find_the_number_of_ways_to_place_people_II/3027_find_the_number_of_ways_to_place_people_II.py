class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:
        ans = 0
        points.sort(key=lambda p: (p[0], -p[1]))
        for i, (_, yi) in enumerate(points):
            maxY = -inf
            for _, yj in points[i + 1:]:
                if yj <= yi and yj > maxY:
                    ans += 1
                    maxY = yj
        return ans

        