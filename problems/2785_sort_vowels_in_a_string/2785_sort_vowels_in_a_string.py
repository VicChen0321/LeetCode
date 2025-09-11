class Solution:
    def sortVowels(self, s: str) -> str:
        vowels = [c for c in s if c.lower() in "aeiou"]
        vowels.sort()
        res = []
        j = 0
        for c in s:
            if c.lower() in "aeiou":
                res.append(vowels[j])
                j += 1
            else:
                res.append(c)
        return "".join(res)