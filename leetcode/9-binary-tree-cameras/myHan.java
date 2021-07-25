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
    private static int solve(TreeNode root, HashSet<Integer> isCovered, HashSet<Integer> isCamera) {
        if(root == null) return 0;
        int ret = solve(root.left, isCovered, isCamera) + solve(root.right, isCovered, isCamera);
        if(
            (root.left != null && isCamera.contains(root.left.hashCode()))
            || (root.right != null && isCamera.contains(root.right.hashCode()))
        ) {
            isCovered.add(root.hashCode());
        }
        if(
            (root.left != null && !isCovered.contains(root.left.hashCode()))
            || (root.right != null && !isCovered.contains(root.right.hashCode()))
        ) {
            isCamera.add(root.hashCode());
            isCovered.add(root.hashCode());
            if(root.left != null) isCovered.add(root.left.hashCode());
            if(root.right != null) isCovered.add(root.right.hashCode());
            ret++;
        }
        
        return ret;
    }
    public int minCameraCover(TreeNode root) {
        HashSet<Integer> isCovered = new HashSet<Integer>();
        HashSet<Integer> isCamera = new HashSet<Integer>();
        int ans = solve(root, isCovered, isCamera);
        if(!isCovered.contains(root.hashCode())) ans++;
        return ans;
    }
}