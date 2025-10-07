class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        TreeSet<Integer> dryDays = new TreeSet<>();
        Map<Integer, Integer> lastRain = new HashMap<>(); // lake -> last rain day

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                ans[i] = -1;
                if (lastRain.containsKey(lake)) {
                    Integer d = dryDays.higher(lastRain.get(lake));
                    if (d == null) {
                        return new int[0];
                    }
                    ans[d] = lake;
                    dryDays.remove(d);
                }
                lastRain.put(lake, i);
            } else {
                dryDays.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}