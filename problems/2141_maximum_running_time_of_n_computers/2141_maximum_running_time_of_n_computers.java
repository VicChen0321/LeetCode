class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long left = 1, right = 0;
        for (int b : batteries)
            right += b; // Sum of batteries
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canRun(n, batteries, mid)) {
                ans = mid; // 可以達到至少 mid，往更大方向找
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canRun(int n, int[] batteries, long target) {
        long sum = 0;
        for (int b : batteries) {
            sum += Math.min(b, target); // 每顆電池最多貢獻 target 電量
        }
        return sum >= (long) n * target;
    }
}
