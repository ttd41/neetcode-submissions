class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] rmax = new int[len];
        int r = 0;
        for (int i = len - 1; i >= 0; i--) {
            r = Math.max(r, height[i]);
            rmax[i] = r;
        }

        int l = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            l = Math.max(l, height[i]);
            res += (Math.min(l, rmax[i]) - height[i]);
        }

        return res;
    }
}
