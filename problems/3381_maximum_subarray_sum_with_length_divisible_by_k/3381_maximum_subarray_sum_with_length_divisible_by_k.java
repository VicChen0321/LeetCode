class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] minPrefix = new long[k];
        final long INF = Long.MAX_VALUE / 2;
        Arrays.fill(minPrefix, INF);
        minPrefix[k - 1] = 0;
        long prefix = 0;
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int r = i % k;
            ans = Math.max(ans, prefix - minPrefix[r]);
            minPrefix[r] = Math.min(minPrefix[r], prefix);
        }
        return ans;
    }
}