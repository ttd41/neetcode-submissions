class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if (n == 1) {
            return 0;
        }

        HashMap<Integer, List<int[]>> edges = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<>());
        }
        for (int[] t: times) {
            if (t[0] == t[1]) continue;
            edges.get(t[0]).add(new int[]{t[1], t[2]});
        }

        if (!edges.containsKey(k)) {
            return -1;
        }

        int num = 1;
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.addAll(edges.get(k));

        // num 1 time 0 pq[[2, 1] [4, 4]] edge [[2,3,1],[3,4,1]]
        // num 2 time 1 pq[[3, 1] [4, 4]] e [[3,4,1]]
        // num 3 time 2 pq[[4, 1] [4, 4]] e [[]
        // num 4 time 3 continue
        // continue
        edges.remove(k);
        while (!pq.isEmpty() && num < n) {
            int[] curr = pq.poll();
            int currI = curr[0];
            int currT = curr[1];
            if (!edges.containsKey(currI)) {
                continue;
            }

            for (int[] e: edges.get(currI)) {
                pq.add(new int[]{e[0], e[1] + currT});
            }
            edges.remove(curr[0]);
            res = Math.max(res, currT);
            
            num++;
        }


        if (num == n) {
            return res;
        }

        return -1;
    }
}
