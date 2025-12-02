class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        MOD = 10 ** 9 + 7
        cnt = defaultdict(int)
        
        for x, y in points:
            cnt[y] += 1
        
        edges = []
        # 計算每條水平線能構造多少水平邊
        for c in cnt.values():
            if c >= 2:
                edges.append(c * (c - 1) // 2)
        
        ans, total = 0, 0
        for e in edges:
            ans = (ans + e * total) % MOD
            total = (total + e) % MOD
        
        return ans
        