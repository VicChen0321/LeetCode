class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        // Store each user knows languages
        Set<Integer>[] userLanguages = new Set[languages.length];
        for (int i = 0; i < languages.length; i++) {
            userLanguages[i] = new HashSet<>();
            for (int lang : languages[i]) {
                userLanguages[i].add(lang);
            }
        }
        // Record know need to teach language users
        Set<Integer> needToTeach = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            Set<Integer> setU = userLanguages[u];
            Set<Integer> setV = userLanguages[v];
            if (Collections.disjoint(setU, setV)) { // Without common language
                needToTeach.add(u);
                needToTeach.add(v);
            }
        }
        // Count the number of people who know each language among those who need to be
        // taught
        int[] languageCount = new int[n + 1];
        for (int user : needToTeach) {
            for (int lang : userLanguages[user]) {
                languageCount[lang]++;
            }
        }
        int maxKnown = 0;
        for (int i = 1; i <= n; i++) {
            maxKnown = Math.max(maxKnown, languageCount[i]);
        }
        return needToTeach.size() - maxKnown;
    }
}