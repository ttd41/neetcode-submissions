class Solution {
    int[][] heights;
    int m;
    int n;

    int[][] paths = {{-1, 0},{1, 0},{0, 1},{0, -1}};
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;

        Deque<int[]> pa = new ArrayDeque<>();
        Deque<int[]> at = new ArrayDeque<>();
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    visited[i][j] += 1;
                    pa.add(new int[]{i, j});
                }
            }
        }

        bfs(visited, pa, 1);

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (i == m - 1 || j == n - 1) {
                    visited[i][j] += 2;
                    at.add(new int[]{i, j});
                }
            }
        }
        bfs(visited, at, 2);

        return res;

    }

    public void bfs(int[][] visited, Deque<int[]> q, int target) {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            if (visited[curr[0]][curr[1]] == 3) {
                res.add(List.of(i, j));
            }
            for (int[] p: paths) {
                int x = i + p[0];
                int y = j + p[1];

                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] >= target || heights[x][y] < heights[i][j]) {
                    continue;
                }
                visited[x][y] += target;
                q.add(new int[]{x, y});
            }
        }
    }
}
