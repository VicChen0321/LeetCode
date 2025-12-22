class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        cnt = [0] * 26
        for c in magazine:
            cnt[ord(c) - ord('a')] += 1
        for c in ransomNote:
            idx = ord(c) - ord('a')
            cnt[idx] -= 1
            if cnt[idx] < 0:
                return False
        return True