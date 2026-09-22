class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> qs = new ArrayList<>();
        for (int qi = 0; qi < queries.length; qi++) {
            qs.add(new int[]{queries[qi], qi});
        }
        Collections.sort(qs, (q1, q2) -> q1[0] - q2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // [len, start, end]
        int ii = 0;
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        for (int[] q: qs) {
            int currq = q[0];
            int qi = q[1];

            while (!pq.isEmpty() && pq.peek()[2] < currq) {
                pq.poll();
            }

            while (ii < intervals.length && intervals[ii][0] <= currq) {
                int[] curri = intervals[ii++];
                if (curri[1] < currq) {
                    continue;
                }
                pq.add(new int[]{curri[1] - curri[0] + 1, curri[0], curri[1]});
            }

            if (!pq.isEmpty()) {
                res[qi] = pq.peek()[0];
            }


        }

        return res;
    }

    // 1,2 2,1 3,4 6,0
    // 3,1 7,4 6,0
}
