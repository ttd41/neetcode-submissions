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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> a = new ArrayDeque<>();
        a.push(root);
        List<List<Integer>> res = new ArrayList<>();

        while (!a.isEmpty()) {
            int size = a.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = a.pollLast();
                if (n != null) {
                    l.add(n.val);
                    if (n.left != null) {
                        a.push(n.left);
                    }
                    if (n.right != null) {
                        a.push(n.right);
                    }
                }
            }
            res.add(l);

        }

        return res;
        
    }
}
