class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        return self.checkSymmetric(root.left, root.right)
    
    def checkSymmetric(self, left, right):
        if left is None or right is None:
            return left == right
        
        if left.val != right.val:
            return False
        
        return self.checkSymmetric(left.left, right.right) and self.checkSymmetric(left.right, right.left)