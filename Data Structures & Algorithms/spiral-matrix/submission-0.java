class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int lm = 0;
        int rm = matrix.length - 1;
        int ln = 0;
        int rn = matrix[0].length - 1;

        List<Integer> res = new ArrayList<>();
        while (lm <= rm && ln <= rn) {
            for (int i = ln; i <= rn; i++) {
                res.add(matrix[lm][i]);
            }


            for (int i = lm + 1; i <= rm; i++) {
                res.add(matrix[i][rn]);
            }


            for (int i = rn - 1; i >= ln && lm < rm; i--) {
                res.add(matrix[rm][i]);
            }

            for (int i = rm - 1; i > lm && ln < rn; i--) {
                res.add(matrix[i][ln]);
            }

            lm++;
            ln++;
            rn--;
            rm--;
        }

        return res;
    }
}
