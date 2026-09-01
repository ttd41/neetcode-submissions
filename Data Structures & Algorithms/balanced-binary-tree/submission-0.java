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
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);

        return res;
    }

    public int dfs(TreeNode n) {
        if (n == null) {
            return 0;
        }
        int lh = dfs(n.left);
        int rh = dfs(n.right);
        if (Math.abs(lh - rh) > 1) {
             res = false;
        }
        return Math.max(lh, rh) + 1;
    }
}
