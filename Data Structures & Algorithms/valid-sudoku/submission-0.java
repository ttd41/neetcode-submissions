class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] v = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int ind = board[i][j] - '1';
                if (v[ind]) {
                    return false;
                } 
                v[ind] = true;
            }
        }

        for (int j = 0; j < 9; j++) {
            boolean[] v = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.')
                    continue;
                int ind = board[i][j] - '1';
                if (v[ind]) {
                    return false;
                } 
                v[ind] = true;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] v = new boolean[9];
                for (int ii = i; ii < i + 3; ii++) {
                    for (int jj = j; jj < j + 3; jj++) {
                        if (board[ii][jj] == '.')
                            continue;
                        int ind = board[ii][jj] - '1';
                        if (v[ind]) {
                            return false;
                        } 
                        v[ind] = true;
                    }
                }
            }
        }

        return true;
    }

}
