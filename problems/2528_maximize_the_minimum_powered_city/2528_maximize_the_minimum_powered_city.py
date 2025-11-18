class Solution:
    def maxPower(self, stations: List[int], r: int, k: int) -> int:
        n = len(stations)
        pref = [0] * (n + 1)
        for i in range(n):
            pref[i+1] = pref[i] + stations[i]

        power = [0] * n
        for i in range(n):
            L = max(0, i - r)
            R = min(n - 1, i + r)
            power[i] = pref[R+1] - pref[L]

        def can(mid):
            diff = [0] * (n + 1) 
            cur_add = 0
            used = 0
            for i in range(n):
                cur_add += diff[i] 
                cur_power = power[i] + cur_add
                if cur_power < mid:
                    need = mid - cur_power
                    used += need
                    if used > k:
                        return False
                    cur_add += need
                    end = i + 2 * r + 1
                    if end > n:
                        end = n
                    diff[end] -= need
            return True

        low, high = 0, sum(stations) + k 
        ans = 0
        while low <= high:
            mid = (low + high) // 2
            if can(mid):
                ans = mid
                low = mid + 1
            else:
                high = mid - 1
        return ans
