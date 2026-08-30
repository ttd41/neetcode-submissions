class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int h = matrix.length;
        int w = matrix[0].length;
        int l = 0, r = h * w;
        while (l < r) {
            int m = l + (r - l) / 2;
            int v = map(matrix, m, w);
            if (v == target) {
                return true;
            } else if (v < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return false;
    }

    public int map(int[][] matrix, int raw, int w) {
        int x = raw / w;
        int y = raw % w;
        return matrix[x][y];
    }
}
