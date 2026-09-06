class Solution {

    int[][] grid;
    int m;
    int n;
    int res;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;     
        this.res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res,  dfs(i, j));
            }
        }

        return res;
    }

    public int dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        if (grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = -1;
        int area = dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j-1) + dfs(i, j+1) + 1;

        return area;
    }
}
