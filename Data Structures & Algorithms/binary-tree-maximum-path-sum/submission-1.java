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

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lm = dfs(root.left);
        int rm = dfs(root.right);

        res = Math.max(res, root.val + lm + rm);

        return Math.max(0, root.val + Math.max(lm, rm));
    }

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
}
