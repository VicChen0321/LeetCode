public class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : power)
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        List<Integer> nums = new ArrayList<>(cnt.keySet());
        Collections.sort(nums);
        int n = nums.size();
        long[] dp = new long[n + 1];
        long[] total = new long[n];
        for (int i = 0; i < n; i++)
            total[i] = (long) nums.get(i) * cnt.get(nums.get(i));
        for (int i = 0; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && nums.get(j) >= nums.get(i) - 2)
                j--;
            long pick = total[i] + (j >= 0 ? dp[j + 1] : 0);
            dp[i + 1] = Math.max(dp[i], pick);
        }
        return dp[n];
    }
}