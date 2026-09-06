/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return dfs(node, new Node[101]);
    }

    public Node dfs(Node n, Node[] visited) {
        if (n == null) {
            return null;
        }

        if (visited[n.val] != null) {
            return visited[n.val];
        }

        Node res = new Node(n.val);
        visited[n.val] = res;

        if (n.neighbors != null) {
            List<Node> ns = new ArrayList<>();
            for (Node node: n.neighbors) {
                ns.add(dfs(node, visited));
            }

            res.neighbors = ns;
        }


        return res;
    }
}