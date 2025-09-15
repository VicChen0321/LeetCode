class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] brokenKeys = new boolean[26];
        int res = 0;
        for (char c : brokenLetters.toCharArray()) {
            brokenKeys[c - 'a'] = true;
        }
        for (String word : text.split(" ")) {
            res++;
            for (char c : word.toCharArray()) {
                if (brokenKeys[c - 'a']) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}