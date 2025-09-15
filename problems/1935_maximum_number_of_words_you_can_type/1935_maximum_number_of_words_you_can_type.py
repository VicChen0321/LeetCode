class Solution:
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        broken = set(brokenLetters)
        res = 0
        for word in text.split():
            if not any(c in broken for c in word):
                res += 1
        return res