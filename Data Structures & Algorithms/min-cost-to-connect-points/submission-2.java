class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        int visited = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        int curr = 0;
        int next = -1;
        dist[curr] = 0;
        visited++;
        int res = 0;
        while (visited < n) {
            int[] currP = points[curr];
            int mind = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (dist[j] == 0) continue;
                int d = distance(currP, points[j]);
                dist[j] = Math.min(dist[j], d);
                if (dist[j] < mind) {
                    next = j;
                    mind = dist[j];
                }
            }
            res += dist[next];
            dist[next] = 0;
            curr = next;
            visited++;
        }

        return res;
    }

    public int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
