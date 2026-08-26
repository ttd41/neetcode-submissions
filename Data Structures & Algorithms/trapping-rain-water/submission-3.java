class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1, lm = height[0], rm = height[len - 1];
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                lm = Math.max(height[l], lm);
                res += lm - height[l];
                l++;
            } else {
                rm = Math.max(height[r], rm);
                res += rm - height[r];
                r--;
            }
        }

        return res;
    }
}
