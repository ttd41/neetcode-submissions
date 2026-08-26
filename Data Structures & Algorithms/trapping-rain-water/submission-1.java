class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1, lm = height[0], rm = height[len - 1];
        int res = 0;
        while (l < r) {
            if (lm < rm) {
                while (l < r && height[l] <= lm) {
                    res += lm - height[l];
                    l++;
                }
                lm = height[l];
            } else {
                while (l < r && height[r] <= rm) {
                    res += rm - height[r];
                    r--;
                }
                rm = height[r];
            }


        }

        return res;
    }
}
