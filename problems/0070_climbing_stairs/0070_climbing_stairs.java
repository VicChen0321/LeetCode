class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int cur = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = cur;
        }
        return dp[1];
    }
}