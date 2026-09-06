class Solution {
    int[][] grid;
    int m;
    int n;

    public void islandsAndTreasure(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bfs(i, j);
            }
        }
    }

    public void bfs(int i, int j) {
        if (grid[i][j] != 0) {
            return;
        }

        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        dq.add(new int[]{i , j});
        int dis = 0;

        while (!dq.isEmpty()){
            int len = dq.size();
            for (int l = 0; l < len; l++) {
                int[] c = dq.poll();
                int x = c[0];
                int y = c[1];
                if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == -1 || visited[x][y]) {
                    continue;
                }
                if (dis >= 1 && grid[x][y] == 0) {
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

        return;


    }
}
