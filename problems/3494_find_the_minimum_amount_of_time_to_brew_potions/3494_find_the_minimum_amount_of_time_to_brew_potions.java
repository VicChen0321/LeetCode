class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long left = 0, right = (long) Arrays.stream(skill).max().getAsInt()
                * (long) Arrays.stream(mana).max().getAsInt();
        long totalMana = 0;
        for (int x : mana)
            totalMana += x;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canFinish(skill, mana, totalMana, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] skill, int[] mana, long totalMana, long T) {
        long sum = 0;
        for (int s : skill) {
            sum += T / s;
            if (sum >= totalMana)
                return true;
        }
        return false;
    }
}