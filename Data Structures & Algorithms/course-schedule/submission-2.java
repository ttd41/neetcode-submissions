class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for (int[] p: prerequisites) {
            List<Integer> list = hm.getOrDefault(p[1], new ArrayList<>());
            list.add(p[0]);
            hm.put(p[1], list);
        }

        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i) && !dfs(i, new HashSet<>(), visited, hm)) {
                return false;
            }
        }

        return true;

    }

    public boolean dfs(int i, HashSet<Integer> seen, HashSet<Integer> visited, HashMap<Integer, List<Integer>> hm) {
        if (seen.contains(i)) {
            return false;
        }

        if (!hm.containsKey(i)) {
            return true;
        }

        if (visited.contains(i)) {
            return true;
        }

        seen.add(i);
        for (Integer ii: hm.getOrDefault(i, new ArrayList<>())) {
            if (!dfs(ii, seen, visited, hm)) {
                return false;
            }
        }
        visited.add(i);
        seen.remove(i);

        return true;
    }
}
