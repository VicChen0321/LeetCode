class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        List<Character> vowels = new ArrayList<>();
        for (char ch : chars) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }
        if (vowels.size() == 0) {
            return s;
        }

        Collections.sort(vowels);
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                chars[i] = vowels.get(j++);
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
}