class Solution {

    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> dia = new HashSet<>();
    HashSet<Integer> rdia = new HashSet<>();
    int n;
    StringBuilder row;
    List<List<String>> res;


    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        row = new StringBuilder();
        res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            row.append(".");
        }
        backtrack(0, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int i, int j, List<String> prev) {

        if (prev.size() ==  n) {
            res.add(new ArrayList<>(prev));
            return;
        }

        if (i == n) {
            return;
        }

        if (!cols.contains(j) && !dia.contains(i - j) && !rdia.contains(i + j)) {
            cols.add(j);
            dia.add(i - j);
            rdia.add(i + j);
            row.setCharAt(j, 'Q');
            prev.add(row.toString());
            row.setCharAt(j, '.');
            backtrack(i + 1, 0, prev);
            prev.remove(prev.size() - 1);
            cols.remove(j);
            dia.remove(i - j);
            rdia.remove(i + j);
        }

        if (j == n - 1) {
            backtrack(i + 1, 0, prev);
        } else {
            backtrack(i, j + 1, prev);
        }

    }
}
