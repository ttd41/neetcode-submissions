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
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int len = preorder.length;
        return buildTree(0, len - 1, 0, len - 1);
        
    }

    public TreeNode buildTree(int sp, int ep, int si, int ei) {
        if (sp > ep || si > ei) {
            return null;
        }

        if (sp == ep && si == ei) {
            return new TreeNode(preorder[sp]);
        }

        int rootVal = preorder[sp];
        TreeNode node = new TreeNode(rootVal);
        int i = si;
        while (i <= ei && inorder[i] != rootVal) {
            i++;
        }
        int len = i - si;
        node.left = buildTree(sp + 1, sp + len, si, i - 1);
        node.right = buildTree(sp + len + 1, ep, i + 1, ei);

        return node;
    }
}


