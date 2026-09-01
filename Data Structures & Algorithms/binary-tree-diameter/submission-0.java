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
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        return res;
    }

    public int dfs(TreeNode n) {
        if (n == null) {
            return 0;
        }
        int lm = dfs(n.left);
        int rm = dfs(n.right);
        res = Math.max(res, lm + rm);
        return Math.max(lm, rm) + 1;
    }
}
