class Solution:
    def maxFreqSum(self, s: str) -> int:
        cnt = Counter(s)
        max_vowel = 0
        max_consonant = 0
        for c, v in cnt.items():
            if c in "aeiou":
                max_vowel = max(max_vowel, v)
            else:
                max_consonant = max(max_consonant, v)
        return max_vowel + max_consonant