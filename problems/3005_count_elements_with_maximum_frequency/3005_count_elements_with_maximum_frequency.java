class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] mem = new int[101];
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            mem[num]++;
            max = Math.max(max, mem[num]);
        }
        int sum = 0;
        for (int count : mem) {
            if (count == max) {
                sum += count;
            }
        }
        return sum;
    }
}