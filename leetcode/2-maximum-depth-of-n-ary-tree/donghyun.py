"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
from collections import deque


class Solution:
    def maxDepth(self, root: 'Node') -> int:
        dq = deque([(root, 1)] if root else [])
        max_d = 0
        while len(dq) != 0:
            node, depth = dq.pop()
            max_d = max(max_d, depth)
            for nd in node.children:
                dq.appendleft((nd, depth + 1))
        return max_d
