class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        HashMap<Integer, List<int[]>> hm = new HashMap<>();
        pq.add(new int[]{src, 0, 0});
        for (int[] f: flights) {
            hm.computeIfAbsent(f[0], key -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }
        prices[src] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            int uk = curr[2];
            for (int[] next: hm.getOrDefault(u, new ArrayList<>())) {
                int v = next[0];
                int w = next[1];
                if (prices[v] > d + w) {
                    prices[v] = d + w;
                    if (uk == k) continue;
                    pq.add(new int[]{v, d + w, uk + 1});
                }
            }
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];



        
    }
}
