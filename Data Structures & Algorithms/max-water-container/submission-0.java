class Solution {
    public int maxArea(int[] heights) {
        int len = heights.length;
        int l = 0, r = len - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, Math.min(heights[l], heights[r]) * (r - l));
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
        
    }
}
