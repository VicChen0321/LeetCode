class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        for (int num : nums) {
            int cur = num;
            while (!stack.isEmpty()) {
                int last = stack.get(stack.size() - 1);
                int g = gcd(last, cur);
                if (g == 1)
                    break;
                stack.remove(stack.size() - 1);
                cur = lcm(last, cur);
            }
            stack.add(cur);
        }
        return stack;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}