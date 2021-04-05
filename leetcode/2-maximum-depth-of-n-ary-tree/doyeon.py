"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def maxDepth(self, root: 'Node') -> int:
        return self.intoNode(root, 1)
    
    def intoNode(self, node, d):
        if not node:
            return 0
        
        nextNodes = node.children
        if nextNodes:
            nextDepths = []
            for i in range(len(nextNodes)):
                nextDepths.append(self.intoNode(nextNodes[i], d+1))
            return max(nextDepths)
        else:
            return d