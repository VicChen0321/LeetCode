class Solution:
    def longestPalindrome(self, s: str) -> int:
        res = 0
        counts = collections.Counter(s)
        
        for count in counts.values():
            res += (count // 2) * 2
            if count % 2 == 1 and res % 2 == 0:
                res += 1
        return res