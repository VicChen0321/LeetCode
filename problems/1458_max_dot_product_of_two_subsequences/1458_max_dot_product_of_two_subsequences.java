class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currProd = nums1[i] * nums2[j];
                dp[i][j] = currProd;
                // 1. 考慮之前累加的最優解
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j], currProd + dp[i - 1][j - 1]);
                }
                // 2. 考慮不選 nums1[i] 或不選 nums2[j]
                if (i > 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j > 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}