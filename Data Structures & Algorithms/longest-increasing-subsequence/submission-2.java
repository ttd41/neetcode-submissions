class Solution {

    
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

        }
        
        return Arrays.stream(dp).max().getAsInt();
    }
}
