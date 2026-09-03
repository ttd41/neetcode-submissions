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
    int pi;
    int ii;
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pi = 0;
        ii = 0;
        this.preorder = preorder;
        this.inorder = inorder;
        return dfs(Integer.MAX_VALUE);
        
    }

    public TreeNode dfs(int limit) {
        if (pi >= preorder.length) {
            return null;
        }

        if (inorder[ii] == limit) {
            ii++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[pi++]);
        root.left = dfs(root.val);
        root.right = dfs(limit);
        return root;

    }


}


