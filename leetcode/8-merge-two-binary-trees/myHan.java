/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static void merge(TreeNode root, TreeNode root1, TreeNode root2) {
        root.val = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);
        if((root1 != null && root1.left != null) || (root2 != null && root2.left != null)) {
            root.left = new TreeNode();
            merge(root.left, root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        }
        if((root1 != null && root1.right != null) || (root2 != null && root2.right != null)) {
            root.right = new TreeNode();
            merge(root.right, root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        }
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        TreeNode root = new TreeNode();
        merge(root, root1, root2);
        return root;
    }
}