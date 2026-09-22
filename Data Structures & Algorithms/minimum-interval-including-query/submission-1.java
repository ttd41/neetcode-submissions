class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] inter = intervals[i];
            events.add(new int[]{inter[0], 0, inter[1] - inter[0] + 1, i});
            events.add(new int[]{inter[1], 2, inter[1] - inter[0] + 1, i});
        }

        for (int i = 0; i < queries.length; i++) {
            events.add(new int[]{queries[i], 1, -1, i});
        }

        Collections.sort(events, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);


        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);
        boolean[] isActive = new boolean[intervals.length];
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        for (int[] e: events) {
            if (e[1] == 0) {
                pq.add(e);
                isActive[e[3]] = true;
            } else if (e[1] == 2) {
                isActive[e[3]] = false;
            } else {
                while (!pq.isEmpty() && !isActive[pq.peek()[3]]) {
                    pq.poll();
                }
                if (!pq.isEmpty()) {
                    res[e[3]] = pq.peek()[2];
                }
            }
        }

        return res;
    }

    // 1,2 2,1 3,4 6,0
    // 3,1 7,4 6,0
}
