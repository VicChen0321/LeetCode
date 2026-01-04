class Solution:
    def sumFourDivisors(self, nums: List[int]) -> int:
        total_sum = 0
        for num in nums:
            cur_sum = 0
            count = 0

            for i in range(1, int(num ** 0.5) + 1):
                if num % i == 0:
                    if i * i == num: 
                        count += 1
                        cur_sum += i
                    else:
                        count += 2
                        cur_sum += (i + num // i)
                if count > 4:
                    break
            if count == 4:
                total_sum += cur_sum
        return total_sum