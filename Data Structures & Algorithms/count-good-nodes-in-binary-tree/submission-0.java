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

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return res;
    }

    public void dfs(TreeNode root, int prevMax) {
        if (root == null) {
            return;
        }
        if (prevMax <= root.val) {
            res++;
        } 
        dfs(root.left, Math.max(prevMax, root.val));
        dfs(root.right, Math.max(prevMax, root.val));
    }
}
