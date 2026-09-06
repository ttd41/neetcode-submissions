class Solution {
    char[][] grid;
    int m;
    int n;
    int res;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i , j)) {
                    res ++;
                }
            }
        }

        return res;
        
    }

    public boolean dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        if (grid[i][j] != '1') {
            return false;
        }


        grid[i][j] = '2';
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);


        return true;


    }
}
