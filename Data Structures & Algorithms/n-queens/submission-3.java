class Solution {

    int col = 0, dia = 0, rdia = 0;
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
        backtrack(0, new ArrayList<>());
        return res;
    }

    public void backtrack(int i, List<String> prev) {

        if (prev.size() ==  n) {
            res.add(new ArrayList<>(prev));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (((col & (1 << j)) == 0) && 
                (dia & (1 << (i - j + n))) == 0 && 
                (rdia & (1 << (i + j))) == 0) {
                col ^= (1 << j);
                dia ^= (1 << (i - j + n));
                rdia ^= (1 << (i + j));
                row.setCharAt(j, 'Q');
                prev.add(row.toString());
                row.setCharAt(j, '.');
                backtrack(i + 1, prev);
                prev.remove(prev.size() - 1);
                col ^= (1 << j);
                dia ^= (1 << (i - j + n));
                rdia ^= (1 << (i + j));
            }

        }

    }
}
