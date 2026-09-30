class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;

        int res = 0;
        int rm = height[r];
        int lm = height[0];
        while (l <= r) {
            if (lm < rm) {
                lm = Math.max(lm, height[l]);
                res += (Math.min(lm, rm) <= height[l] ? 0 : Math.min(lm, rm) - height[l]);
                l++;
            } else {
                rm = Math.max(rm, height[r]);
                res += (Math.min(lm, rm) <= height[r] ? 0 : Math.min(lm, rm) - height[r]);
                r--;
            }
        }

        return res;
    }
}
