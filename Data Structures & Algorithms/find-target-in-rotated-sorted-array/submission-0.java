class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[len - 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int p = l;
        l = 0;
        r = len;
        while (l < r) {
            int m = l + (r - l) / 2;
            int curr = nums[(m + p) % len];
            if (curr > target) {
                r = m;
            } else if (curr == target) {
                return (m + p) % len;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
