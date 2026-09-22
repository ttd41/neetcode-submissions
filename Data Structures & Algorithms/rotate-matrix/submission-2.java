class Solution {
    public void rotate(int[][] matrix) {

        int l = 0;
        int r = matrix.length - 1;
        
        while (l < r) {
            for (int i = 0; i < r - l; i++) {

                int saved = matrix[l][i + l];

                matrix[l][i + l] = matrix[r - i][l];

                matrix[r - i][l] = matrix[r][r - i];    

                matrix[r][r - i] = matrix[l + i][r];

                matrix[l + i][r] = saved;

            }
            l++;
            r--;
        }
    }
}
