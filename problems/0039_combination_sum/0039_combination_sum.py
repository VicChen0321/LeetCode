class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        
        def backtrack(target: int, start: int, cur: List[int]):
            if target == 0:
                res.append(list(cur))
                return
            elif target < 0:
                return
            
            for i in range(start, len(candidates)):
                cur.append(candidates[i])
                backtrack(target - candidates[i], i, cur)
                cur.pop()
        backtrack(target, 0, [])
        return res