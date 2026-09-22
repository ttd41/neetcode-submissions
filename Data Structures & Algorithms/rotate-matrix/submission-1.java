class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int l = 0; l < len / 2; l++) {

            int[] prev = new int[len - 2*l - 1];
            for (int i = 0; i < len - 2*l - 1; i++) {
                prev[i] = matrix[i + l][len - l - 1];
                matrix[i + l][len - l - 1] = matrix[l][i + l];
            }

            for (int i = 0; i < len - 2*l - 1; i++) {
                int roll = prev[i];
                prev[i] = matrix[len - l - 1][len - i - l - 1];
                matrix[len - l - 1][len - i - l - 1] = roll;
            }

            for (int i = 0; i < len - 2*l - 1; i++) {
                int roll = prev[i];
                prev[i] = matrix[len - i - l - 1][l];
                matrix[len - i - l - 1][l] = roll;
            }

            for (int i = 0; i < len - 2*l - 1; i++) {
                int roll = prev[i];
                prev[i] = matrix[l][i + l];
                matrix[l][i + l] = roll;
            }

        }
    }
}
