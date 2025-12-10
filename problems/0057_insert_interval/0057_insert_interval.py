class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        for interval in intervals:
            # new interval comes before the current interval (no overlap)
            if newInterval[1] < interval[0]:
                res.append(newInterval)
                newInterval = interval
            # new interval comes after the current interval (no overlap)
            elif newInterval[0] > interval[1]:
                res.append(interval)
            # overlap -> merge
            else:
                newInterval = [min(newInterval[0], interval[0]),
                               max(newInterval[1], interval[1])]
        res.append(newInterval)
        return res