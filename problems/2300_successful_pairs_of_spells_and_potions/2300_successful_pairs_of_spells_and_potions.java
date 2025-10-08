class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            // ceil integer
            int spell = spells[i];
            long need = (success + spell - 1) / spell;
            int idx = binarySearch(potions, need);
            res[i] = m - idx;
        }
        return res;
    }

    private int binarySearch(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if ((long) arr[mid] >= target) { // find first >= target
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}