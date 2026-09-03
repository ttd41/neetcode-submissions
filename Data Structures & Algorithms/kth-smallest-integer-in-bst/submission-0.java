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
    int gk = -1;
    int res = -1;

    public int kthSmallest(TreeNode root, int k) {
        gk = k;
        dfs(root, 0);
        return res;
    }

    public int dfs(TreeNode t, int lc) {
        if (t == null) {
            return lc;
        }
        int k = dfs(t.left, lc) + 1;
        if (k == gk) {
            res = t.val;
        }
        return dfs(t.right, k);
        
    }
}
