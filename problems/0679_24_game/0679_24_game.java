class Solution {
    private static final double EPSILON = 1e-6;
    private static final double TARGET = 24.0;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            list.add((double) i);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            if (Math.abs(list.get(0) - TARGET) < EPSILON) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (double c : compute(list.get(i), list.get(j))) {
                    List<Double> next = new ArrayList<>();
                    next.add(c);
                    for (int k = 0; k < list.size(); k++) {
                        if (k == j || k == i)
                            continue;
                        next.add(list.get(k));
                    }
                    if (dfs(next))
                        return true;
                }
            }
        }
        return false;

    }

    private List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        res.add(a / b);
        res.add(b / a);
        return res;
    }
}