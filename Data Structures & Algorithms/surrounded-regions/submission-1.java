class Solution {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == m-1 || j == n-1)) {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }

    public void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'V';

        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);

    }
}
