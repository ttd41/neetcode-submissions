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
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);

        return res;
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (res != null) {
            return;
        }
        if (root == null) {
            return;
        }
        dfs(root.left, p, q);
        dfs(root.right, p, q);
        if (res == null && inTree(root, p) && inTree(root, q)) {
            res = root;
        }
    }

    public boolean inTree(TreeNode root, TreeNode n) {
        if (root == n) {
            return true;
        } 

        if (root == null) {
            return false;
        }

        return inTree(root.left, n) || inTree(root.right, n);

    }
}
