# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def _isSymmetric(self, l, r):
        if l is None and r is None:
            return True
        elif l is None:
            return False
        elif r is None:
            return False
        elif l.val != r.val:
            return False
        else:
            return self._isSymmetric(l.left, r.right) and self._isSymmetric(l.right, r.left)
    def isSymmetric(self, root: TreeNode) -> bool:
        return self._isSymmetric(root.left, root.right)