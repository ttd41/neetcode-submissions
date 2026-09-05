class Solution {
    char[][] board;

    boolean res;

    int[][] paths = new int[][]{{-1,0}, {1,0},{0, 1},{0, -1}};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(i, j, word, 0, visited);
            }
        }
        return res;
    }

    public void backtrack(int x, int y, String word, int index, boolean[][] visited) {

        if (visited[x][y]) {
            return;
        }

        if (res) {
            return;
        }
        
        if (board[x][y] != word.charAt(index)) {
            return;
        }

        if (index == word.length() - 1) {
            res = true;
            return;
        }
        visited[x][y] = true;

        for (int[] p: paths) {
            int nx = x + p[0];
            int ny = y + p[1];
            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
                continue;
            }
            backtrack(nx, ny, word, index + 1, visited);
        }

        visited[x][y] = false;

        return;
    }
}
