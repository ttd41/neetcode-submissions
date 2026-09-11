class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int curr = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = curr;
        }

        return dp[1];
    }
}
