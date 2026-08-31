class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length;
        int len = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[len - 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l];
    }
}
