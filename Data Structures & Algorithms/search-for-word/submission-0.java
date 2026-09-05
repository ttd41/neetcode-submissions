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
                visited[i][j] = true;
                backtrack(i, j, word, 0, visited);
                visited[i][j] = false;
            }
        }
        return res;
    }

    public void backtrack(int x, int y, String word, int index, boolean[][] visited) {

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

        for (int[] p: paths) {
            int nx = x + p[0];
            int ny = y + p[1];
            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length || visited[nx][ny]) {
                continue;
            }
            visited[nx][ny] = true;
            backtrack(nx, ny, word, index + 1, visited);
            visited[nx][ny] = false;
        }

        return;
    }
}
