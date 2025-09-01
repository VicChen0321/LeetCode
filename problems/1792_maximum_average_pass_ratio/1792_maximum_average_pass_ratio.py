class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        def extra_gain(p, t):
            return (p + 1) / (t + 1) - p / t
        
        heap = [(-extra_gain(p, t), p, t) for p, t in classes]
        heapify(heap)

        for _ in range(extraStudents):
            neg_gain, p, t = heappop(heap)
            p, t = p + 1, t + 1
            heappush(heap, (-extra_gain(p, t), p, t))        
        
        return sum(p / t for _, p, t in heap) / len(classes)