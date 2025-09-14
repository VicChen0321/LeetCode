class Solution:
    def spellchecker(self, wordlist: List[str], queries: List[str]) -> List[str]:
        def mask(word: str) -> str:
            vowels = set(["a", "e", "i", "o", "u"])
            mask_word = ""
            for c in word:
                if c in vowels:
                    mask_word += "*"
                else: 
                    mask_word += c
            return mask_word
        
        exact = set(wordlist)
        caseMap = {}
        vowelMap = {}

        for w in wordlist:
            lw = w.lower()
            caseMap.setdefault(lw, w)
            vowelMap.setdefault(mask(lw), w)
        
        res = []
        for q in queries:
            if q in exact:
                res.append(q)
            else:
                lq = q.lower()
                if lq in caseMap:
                    res.append(caseMap[lq])
                elif mask(lq) in vowelMap:
                    res.append(vowelMap[mask(lq)])
                else:
                    res.append("")
        return res

    