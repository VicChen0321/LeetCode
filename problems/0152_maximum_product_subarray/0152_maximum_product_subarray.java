class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(cur, cur * max);
            min = Math.min(cur, cur * min);
            res = Math.max(res, max);
        }
        return res;
    }
}