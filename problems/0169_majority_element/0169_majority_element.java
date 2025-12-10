class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
            }
            if (candidate == num)
                cnt++;
            else
                cnt--;
        }
        return candidate;
    }
}