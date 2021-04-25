/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

const isMirror = (n1, n2) => {
  if (n1 === null && n2 === null) {
    return true
  }

  if (n1 !== null && n2 !== null && n1.val === n2.val) {
    return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left)
  }

  return false
}

function isSymmetric(root: TreeNode | null): boolean {
  return isMirror(root.left, root.right)
}
