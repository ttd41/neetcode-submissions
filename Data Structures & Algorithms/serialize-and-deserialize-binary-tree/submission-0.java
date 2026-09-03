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

public class Codec {


    int deSerIndex = 0;


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        List<String> l = new ArrayList<>();

        dfsSer(root, l);
        
        return String.join(",", l);
    }


    public void dfsSer(TreeNode tn, List<String> l) {
        if (tn == null) {
            l.add("null");
            return;
        }
        l.add(String.valueOf(tn.val));
        dfsSer(tn.left, l);
        dfsSer(tn.right, l);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        deSerIndex = 0;
        String[] l = data.split(",");
        return dfsDeser(l);
        
    }

    public TreeNode dfsDeser(String[] l) {
        if (l[deSerIndex].equals("null")) {
            deSerIndex++;
            return null;
        }
        TreeNode tn = new TreeNode(Integer.valueOf(l[deSerIndex++]));
        tn.left = dfsDeser(l);
        tn.right = dfsDeser(l);
        return tn;
    }
}
