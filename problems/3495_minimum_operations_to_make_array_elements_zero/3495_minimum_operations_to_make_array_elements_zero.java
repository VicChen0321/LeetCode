class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int q[] : queries) {
            int l = q[0], r = q[1];
            ans += (getOps(r) - getOps(l - 1) + 1) / 2;
        }
        return ans;
    }

    private long getOps(int n) {
        long res = 0;
        int steps = 0;
        for (long base = 1; base <= n; base *= 4) {
            steps++;
            long end = Math.min(n, base * 4 - 1);
            res += (end - base + 1) * steps;
        }
        return res;
    }
}