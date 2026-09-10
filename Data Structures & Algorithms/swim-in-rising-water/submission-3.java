class Solution {


    public int swimInWater(int[][] grid) {
        int[][] paths = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        pq.add(new int[]{0, 0, grid[0][0]});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            if (i == m - 1 && j == n - 1) return curr[2];
            visited[i][j] = true;
            for (int[] p: paths) {
                int x = i + p[0];
                int y = j + p[1];
                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) continue;
                int d = Math.max(curr[2], grid[x][y]);
                pq.add(new int[]{x, y, d});
            }
        }

        return -1;
    }
}
