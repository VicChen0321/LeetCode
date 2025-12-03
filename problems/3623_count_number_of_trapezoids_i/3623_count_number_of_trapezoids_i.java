class Solution {
    final int MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : points) {
            int y = p[1];
            map.put(y, map.getOrDefault(y, 0) + 1);
        }
        // 計算每一條水平線，可以構造多少條水平邊
        List<Long> edges = new ArrayList<>();
        for (int cnt : map.values()) {
            if (cnt >= 2) {
                long c2 = (long) cnt * (cnt - 1) / 2; // C(n, 2)
                edges.add(c2);
            }
        }
        long ans = 0, sum = 0;
        for (long e : edges) {
            // 選這條作為上邊，再從 sum（之前的所有水平邊）選一條作為下邊
            ans = (ans + e * sum) % MOD;
            sum = (sum + e) % MOD;
        }
        return (int) ans;
    }
}