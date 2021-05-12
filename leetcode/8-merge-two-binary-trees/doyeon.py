# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def mergeTrees(self, root1: TreeNode, root2: TreeNode) -> TreeNode:
        if not root1 and not root2: return None
        merge = TreeNode((root1.val if root1 else 0) + (root2.val if root2 else 0))
        merge.left = self.mergeTrees(root1 and root1.left, root2 and root2.left)
        merge.right = self.mergeTrees(root1 and root1.right, root2 and root2.right)
        return merge
#         def search(node1, node2, merge):
#             if node1 == None and node2 == None:
#                 return
#             node1 = TreeNode() if node1 == None else node1
#             node2 = TreeNode() if node2 == None else node2
#             newVal = node1.val+node2.val
#             merge.val = newVal
#             if node1.left != None or node2.left != None:
#                 merge.left = TreeNode()
#                 search(node1.left, node2.left, merge.left)
#             if node1.right != None or node2.right != None:
#                 merge.right = TreeNode()
#                 search(node1.right, node2.right, merge.right)
        
#         search(root1, root2, merge)
#         return merge