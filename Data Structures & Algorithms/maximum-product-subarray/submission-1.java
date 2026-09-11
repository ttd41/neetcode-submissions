class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int dp1 = 1, dp2 = 1;
        int res = Integer.MIN_VALUE;

        for (int num: nums) {
            int curr1 = dp1 * num;
            int curr2 = dp2 * num;
            int max = Math.max(curr1, curr2);
            int min = Math.min(curr1, curr2);
            dp1 = Math.max(max, 1);
            dp2 = Math.min(min, 1);
            res = Math.max(res, max);
        }

        return res;
    }
}
