# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        all_sums = []

        def get_sum(node):
            if not node:
                return 0
            
            curr_sum = get_sum(node.left) + get_sum(node.right) + node.val
            all_sums.append(curr_sum)
            return curr_sum
        
        total_sum = get_sum(root)

        max_p = 0
        for s in all_sums:
            p = s * (total_sum - s)
            if p > max_p:
                max_p = p
        
        return max_p % (10**9 + 7)