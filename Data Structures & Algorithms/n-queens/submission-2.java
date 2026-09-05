class Solution {
    int col = 0, dia = 0, rdia = 0;
    List<List<String>> res = new ArrayList<>();
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(0, n);
        return res;
    }

    private void backtrack(int r, int n) {
        if (r == n) {
            List<String> copy = new ArrayList<>(n);
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for (int c = 0; c < n; c++) {
            if ((col & (1 << c)) == 0 &&
                (dia & (1 << (r - c + n))) == 0 &&
                (rdia & (1 << (r + c))) == 0) {

                col ^= (1 << c);
                dia ^= (1 << (r - c + n));
                rdia ^= (1 << (r + c));
                board[r][c] = 'Q';

                backtrack(r + 1, n);

                board[r][c] = '.';
                col ^= (1 << c);
                dia ^= (1 << (r - c + n));
                rdia ^= (1 << (r + c));
            }
        }
    }
}