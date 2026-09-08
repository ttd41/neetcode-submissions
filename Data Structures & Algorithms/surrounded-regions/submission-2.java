class Solution {

    class DSU {

        int[] p;
        int[] size;
        public DSU(int n) {
            p = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                size[i] = 1;
            }
        }

        public int find(int n) {
            int curr = n;
            if (p[curr] != curr) {
                curr = find(p[curr]);
            }
            return curr;
        }

        public void union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);
            if (p[p1] == p[p2]) {
                return;
            }
            if (size[p1] < size[p2]) {
                p[p1] = p2;
                size[p2] += size[p1]; 
            } else {
                p[p2] = p1;
                size[p1] += size[p2]; 
            }

        }
        
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        DSU dsu = new DSU(m * n + 1);

        int[][] paths = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ( board[i][j] != 'O') continue;
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    dsu.union(i * n + j, m * n);
                } else {
                    for (int[] p: paths) {
                        int ii = i + p[0];
                        int jj = j + p[1];
                        if (board[ii][jj] == 'O') {
                            dsu.union(i * n + j, ii * n + jj);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if(dsu.find(i * n + j) != dsu.find(m * n)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        return;
    }
}
