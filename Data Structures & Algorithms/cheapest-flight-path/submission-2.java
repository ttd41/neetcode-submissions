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
        // index, cost, usedK
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int from = curr[0];
            int cost = curr[1];
            int usedK = curr[2];
            if (dist[usedK][from] != Integer.MAX_VALUE) continue; //visited
            dist[usedK][from] = cost;
            if (usedK == k + 1) continue;
            for (int[] next: map.getOrDefault(from, new ArrayList<>())) {
                int to = next[0];
                int weight = next[1];
                pq.add(new int[]{to, weight + dist[usedK][from], usedK + 1});
            }
        }

        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            minPrice = Math.min(minPrice, dist[i][dst]);
        }

        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
        
    }
}
