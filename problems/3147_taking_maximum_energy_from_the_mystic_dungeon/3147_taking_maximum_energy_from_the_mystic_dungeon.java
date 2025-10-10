class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = energy;
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (i + k < n) {
                dp[i] += dp[i + k];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}