class Solution {

    HashMap<Integer, List<Integer>> hm = new HashMap<>();
    HashSet<Integer> seen = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        

        for (int[] p: prerequisites) {
            List<Integer> list = hm.getOrDefault(p[1], new ArrayList<>());
            list.add(p[0]);
            hm.put(p[1], list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }

        return true;

    }

    public boolean dfs(int i) {
        if (seen.contains(i)) {
            return false;
        }

        if (!hm.containsKey(i)) {
            return true;
        }


        seen.add(i);
        for (Integer ii: hm.getOrDefault(i, new ArrayList<>())) {
            if (!dfs(ii)) {
                return false;
            }
        }
        seen.remove(i);
        hm.put(i, new ArrayList<>());

        return true;
    }
}
