class Solution {
    int[][] grid;
    int m;
    int n;

    public int[][] paths = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        Deque<int[]> queue = new ArrayDeque<>();
        int freshNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshNum++;
                }
            }
        } 

        if (freshNum == 0) {
            return 0;
        }

        int time = -1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] curr = queue.poll();
                for (int[] p: paths) {
                    int x = curr[0] + p[0];
                    int y = curr[1] + p[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1) {
                        continue;
                    }

                    grid[x][y] = 2;
                    freshNum--;
                    queue.add(new int[]{x, y});
                }
            }
            time++;
        }

        return freshNum == 0 ? time : -1;
    }
}
