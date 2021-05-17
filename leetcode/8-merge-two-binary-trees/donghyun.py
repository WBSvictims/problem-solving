# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def mergeTrees(self, root1: TreeNode, root2: TreeNode) -> TreeNode:
        if not root1 and not root2:
            return None
        left1 = root1.left if root1 else None
        left2 = root2.left if root2 else None
        left = self.mergeTrees(left1, left2)
        right1 = root1 and root1.right
        right2 = root2 and root2.right
        right = self.mergeTrees(right1, right2)

        val1 = root1.val if root1 else 0
        val2 = root2.val if root2 else 0
        return TreeNode(val=val1+val2, left=left, right=right)
