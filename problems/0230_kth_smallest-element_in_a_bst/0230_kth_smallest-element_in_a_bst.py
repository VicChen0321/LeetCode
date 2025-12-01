# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        res = 0
        cnt = 0
        def inorder(node: Optional[TreeNode]) -> int:
            nonlocal res, cnt
            if not node:
                return
            inorder(node.left)
            cnt += 1
            if cnt == k:
                res = node.val
                return
            inorder(node.right)
        inorder(root)
        return res