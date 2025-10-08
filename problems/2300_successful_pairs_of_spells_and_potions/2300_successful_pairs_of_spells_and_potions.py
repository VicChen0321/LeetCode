class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        n, m = len(spells), len(potions)
        res = []
        potions.sort()
        for i, spell in enumerate(spells):
            need = (success + spell - 1) // spell
            idx = bisect.bisect_left(potions, need)
            res.append(m - idx)
        return res