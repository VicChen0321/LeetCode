/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    final int MOD = 1_000_000_007;
    List<Long> allSums = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        long totalSum = getSum(root);

        long maxP = 0L;
        for (long s : allSums) {
            long p = s * (totalSum - s);
            if (p > maxP) {
                maxP = p;
            }
        }
        return (int) (maxP % MOD);
    }

    private long getSum(TreeNode node) {
        if (node == null)
            return 0L;

        long curSum = getSum(node.left) + getSum(node.right) + node.val;
        allSums.add(curSum);
        return curSum;
    }
}