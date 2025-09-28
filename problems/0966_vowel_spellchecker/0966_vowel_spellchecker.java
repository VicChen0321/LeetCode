class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactSet = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            String lower = w.toLowerCase();
            caseMap.putIfAbsent(lower, w);
            vowelMap.putIfAbsent(mask(lower), w);
        }

        int n = queries.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String query = queries[i];
            if (exactSet.contains(query)) {
                res[i] = query;
            } else {
                String lower = query.toLowerCase();
                if (caseMap.containsKey(lower)) {
                    res[i] = caseMap.get(lower);
                } else {
                    res[i] = vowelMap.getOrDefault(mask(lower), "");
                }
            }
        }
        return res;
    }

    private String mask(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                c = '*';
            }
            sb.append(c);
        }
        return sb.toString();
    }

}