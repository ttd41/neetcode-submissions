class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inNum = new HashMap<>();
        Map<Integer, List<Integer>> deps = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();

        if (prerequisites.length == 0) {
            return true;
        }

        for (int[] p: prerequisites) {
            inNum.put(p[0], inNum.getOrDefault(p[0], 0) + 1);
            inNum.put(p[1], inNum.getOrDefault(p[1], 0));
            List<Integer> dep = deps.getOrDefault(p[1], new ArrayList<>());
            dep.add(p[0]);
            deps.put(p[1], dep);
        }

        for (Integer key: inNum.keySet()) {
            if (inNum.get(key) == 0) {
                deque.add(key);
            }
        }

        int num = 0;
        while (!deque.isEmpty()) {
            int c = deque.poll();
            num++;
            List<Integer> dep = deps.getOrDefault(c, new ArrayList<>());
            for (int d: dep) {
                int updateI = inNum.get(d)-1;
                if (updateI == 0) {
                    deque.add(d);
                } 
                inNum.put(d, updateI);
            }
        }

        return num == inNum.size();
    
    }
}
