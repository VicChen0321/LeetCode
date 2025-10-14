class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int incr = 1;
        int pre = 0;
        int n = nums.size();

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                incr++;
            } else {
                pre = incr;
                incr = 1;
            }
            if (incr / 2 >= k || Math.min(pre, incr) >= k) {
                return true;
            }
        }
        return false;
    }
}