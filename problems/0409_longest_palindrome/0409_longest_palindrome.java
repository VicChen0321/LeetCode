class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int len = 0;
        for (int v : count) {
            len += (v / 2) * 2;
            if (len % 2 == 0 && v % 2 == 1) {
                len++;
            }
        }
        return len;

    }
}