class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1, lm = height[0], rm = height[len - 1];
        int res = 0;
        while (l < r) {
            lm = Math.max(height[l], lm);
            rm = Math.max(height[r], rm);
            if (lm < rm) {
                res += lm - height[l];
                l++;
            } else {
                res += rm - height[r];
                r--;
            }
        }

        return res;
    }
}
