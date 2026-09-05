class Solution {

    class Trie {
        String s;
        Trie[] ts;
        Trie() {
            this.s = null;
            ts = new Trie[26]; 
        }
    }

    Trie root = new Trie();
    ArrayList<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        buildTrie(words);
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, new boolean[m][n], root);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, boolean[][] visited, Trie t) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        int index = board[i][j] - 'a';

        if (t.ts[index] == null) {
            return;
        }

        if (t.ts[index].s != null) {
            res.add(t.ts[index].s);
            t.ts[index].s = null;
        }

        visited[i][j] = true;

        dfs(board, i + 1, j, visited, t.ts[index]);
        dfs(board, i, j + 1, visited, t.ts[index]);
        dfs(board, i - 1, j, visited, t.ts[index]);
        dfs(board, i, j - 1, visited, t.ts[index]);
        visited[i][j] = false;
        
    }

    public void buildTrie(String[] words) {
        for (String s: words) {
            Trie node = root;
            for (char c: s.toCharArray()) {
                int i = c - 'a';
                if (node.ts[i] == null) {
                    node.ts[i] = new Trie();
                }
                node = node.ts[i];

            }
            node.s = s;
        }
    }
}
