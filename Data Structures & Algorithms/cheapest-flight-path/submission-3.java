class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] f: flights) {
            map.computeIfAbsent(f[0], key -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }

        pq.add(new int[]{src, 0, 0});
        int[][] dist = new int[k + 2][n];
        for (int i = 0; i <= k + 1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][src] = 0;

        // index, cost, usedK
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            int uk = curr[2];
            if (u == dst) return d;
            if (uk == k + 1 || dist[uk][u] < d) continue; //visited
            for (int[] edge: map.getOrDefault(u, new ArrayList<>())) {
                int v = edge[0];
                int weight = edge[1];
                int toCost = weight + dist[uk][u];
                if (toCost < dist[uk + 1][v]) {
                    dist[uk + 1][v] = toCost;
                    pq.add(new int[]{v, toCost, uk + 1});
                }
            }
        }

        return -1;
        
    }
}
