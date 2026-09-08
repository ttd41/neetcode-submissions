class Solution {

    int[] inD;
    Map<Integer, List<Integer>> ctc;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int len = numCourses;
        inD = new int[len];
        ctc = new HashMap<>();
        for (int[] p: prerequisites) {
            List<Integer> l = ctc.getOrDefault(p[1], new ArrayList<>());
            l.add(p[0]);
            ctc.put(p[1], l);
            inD[p[0]]++;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (inD[i] == 0) {
                dq.add(i);
            }
        }

        int[] res = new int[len];
        int num = 0;
        while (!dq.isEmpty()) {
            int from = dq.poll();
            res[num] = from;
            num++;
            for (int to: ctc.getOrDefault(from, new ArrayList<>())) {
                inD[to]--;
                if (inD[to] == 0) {
                    dq.add(to);
                }
            }
        }

        return num == len ? res : new int[]{};
    }
}
