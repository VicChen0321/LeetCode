class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        n = len(rains)
        ans = [-1] * n
        dryDays = SortedList()
        lastRain = {}
        
        for i, lake in enumerate(rains):
            if lake > 0:
                if lake in lastRain:
                    idx = dryDays.bisect_right(lastRain[lake])
                    if idx == len(dryDays):
                        return []
                    dry = dryDays[idx]
                    ans[dry] = lake
                    dryDays.remove(dry)
                lastRain[lake] = i
            else:
                dryDays.add(i)
                ans[i] = 1
        return ans