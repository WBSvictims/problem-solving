# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        tl = self.trav_left(root.left, [])
        tr = self.trav_right(root.right, [])
        return tl == tr

    def trav_left(self, node, acc):
        if node is None:
            acc.append(None)
            return acc
        acc.append(node.val)
        acc = self.trav_left(node.left, acc)
        acc = self.trav_left(node.right, acc)
        return acc

    def trav_right(self, node, acc):
        if node is None:
            acc.append(None)
            return acc
        acc.append(node.val)
        acc = self.trav_right(node.right, acc)
        acc = self.trav_right(node.left, acc)
        return acc
