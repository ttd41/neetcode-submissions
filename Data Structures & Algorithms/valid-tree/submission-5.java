class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>(); 

    HashSet<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        for (int[] e: edges) {
            graph.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            graph.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        dfs(-1, 0);

        return graph.size() == 0;
    }

    public boolean dfs(int prev, int curr) {
        if (visited.contains(curr)) {
            return false;
        }

        if (!graph.containsKey(curr)) {
            return true;
        }

        visited.add(curr);
        for (int to: graph.get(curr)) {
            if (to == prev) {
                continue;
            }
            if (!dfs(curr, to)) {
                return false;
            }
        }
        graph.remove(curr);
        visited.remove(curr);


        return true;
    }

}
