class Solution {
    int[][] grid;
    int m;
    int n;

    public void islandsAndTreasure(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dq.add(new int[]{i , j});
                }
            }
        }

        boolean[][] visited = new boolean[m][n];
        int dis = 0;

        while (!dq.isEmpty()){
            int len = dq.size();
            for (int l = 0; l < len; l++) {
                int[] c = dq.poll();
                int x = c[0];
                int y = c[1];
                if (x < 0 || y < 0 || x >= m || y >= n || (dis != 0 && grid[x][y] != Integer.MAX_VALUE)) {
                    continue;
                }
                visited[x][y] = true;
                grid[x][y] = Math.min(grid[x][y], dis);
                dq.add(new int[]{x - 1, y});
                dq.add(new int[]{x + 1, y});
                dq.add(new int[]{x, y - 1});
                dq.add(new int[]{x, y + 1});
            }
            dis++;
        }
    }
}
