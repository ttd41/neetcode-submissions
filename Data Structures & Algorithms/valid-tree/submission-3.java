class Solution {
    boolean[] visited;
    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {
        visited = new boolean[n];
        for (int[] e: edges) {
            List<Integer> l0 = map.getOrDefault(e[0], new ArrayList<>());
            List<Integer> l1 = map.getOrDefault(e[1], new ArrayList<>());          
            l0.add(e[1]);
            l1.add(e[0]);
            map.put(e[0], l0);
            map.put(e[1], l1);
        }

        boolean res = validation(null, 0);

        for (boolean v: visited) {
            res &= v;
        }

        return res;
    }

    public boolean validation(Integer prev, Integer curr) {
        visited[curr] = true;
        List<Integer> nei = map.get(curr);
        if (nei == null || nei.size() == 0) {
            return true;
        }

        for (Integer i: nei) {
            if (i == prev) {
                continue;
            }
            if (visited[i] || !validation(curr, i)) {
                return false;
            }
        }
        return true;
    }


}
