# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def compare(left, right):
            if not left and not right:
                return True
            elif (not left and right) or (left and not right):
                return False
            elif left.val == right.val:
                return compare(left.right, right.left) and compare(left.left, right.right)
            else:
                return False
        return compare(root.left, root.right) 