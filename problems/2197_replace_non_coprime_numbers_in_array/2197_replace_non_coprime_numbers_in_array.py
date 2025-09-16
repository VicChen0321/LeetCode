class Solution:
    def replaceNonCoprimes(self, nums: List[int]) -> List[int]:
        stack = []
        for num in nums:
            stack.append(num)
            while len(stack) > 1 and gcd(stack[-1], stack[-2]) > 1:
                y = stack.pop()
                z = stack.pop()
                stack.append(lcm(y, z))
        return stack