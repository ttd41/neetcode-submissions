class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        int len2 = matrix[0].length;
        int x = len - 1;
        int y = 0;

        while (x >= 0 && y <= len2 - 1) {
            int m = matrix[x][y];
            if (m == target) {
                return true;
            } else if (m > target) {
                x--;
            } else {
                y++;
            }
        }

        return false;
    }
}
