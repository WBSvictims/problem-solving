# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: TreeNode, val: int):
        ret = []
        node = root
        while True:
            if node == None:
                return
            if node.val == val:
                return node
            
            if node.val < val:
                node = node.right
            else:
                node = node.left