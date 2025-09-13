class Solution {
    public int maxFreqSum(String s) {
        int maxVowel = 0;
        int maxConsonant = 0;
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            counts[idx]++;
            if (isVowel(c)) {
                maxVowel = Math.max(maxVowel, counts[idx]);
            } else {
                maxConsonant = Math.max(maxConsonant, counts[idx]);
            }
        }
        return maxVowel + maxConsonant;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}