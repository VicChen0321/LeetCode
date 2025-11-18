class Solution {
    public long maxPower(int[] stations, int r, int k) {

        int n = stations.length;
        long[] prefix = new long[n + 1];

        // Step 1. 計算 prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stations[i];
        }

        // Step 2. 計算每座城市的初始供電量
        long[] power = new long[n];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            power[i] = prefix[right + 1] - prefix[left];
        }

        // Step 3. Binary Search 範圍
        long left = 0;
        long right = prefix[n] + k; // 上限：所有電站全堆一邊
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canReach(power, r, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // 檢查是否能用 <= k 電站，使每個城市 power >= mid
    private boolean canReach(long[] power, int r, long k, long mid) {
        int n = power.length;
        long[] diff = new long[n + 1];
        long used = 0;
        long add = 0;

        for (int i = 0; i < n; i++) {
            add += diff[i]; // apply 目前的差分變化
            long curPower = power[i] + add;
            if (curPower < mid) {
                long need = mid - curPower;
                used += need;
                if (used > k)
                    return false;

                add += need; // 立刻生效
                int end = i + 2 * r + 1;
                if (end < n)
                    diff[end] -= need; // 在影響結束點移除加成
            }
        }
        return true;
    }
}