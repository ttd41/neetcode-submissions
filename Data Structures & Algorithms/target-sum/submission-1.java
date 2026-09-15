class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[len + 1];
        for (int i = 0; i <= len; i++) {
            dp[i] = new HashMap<>();
        }
        dp[0].put(0, 1);
        for (int i = 0; i < len; i++) {
            for (Map.Entry<Integer, Integer> entry: dp[i].entrySet()) {
                dp[i + 1].put(entry.getKey() - nums[i], dp[i + 1].getOrDefault(entry.getKey() - nums[i], 0) + entry.getValue());
                dp[i + 1].put(entry.getKey() + nums[i], dp[i + 1].getOrDefault(entry.getKey() + nums[i], 0) + entry.getValue());
            }
        }

        return dp[len].getOrDefault(target, 0);
    }
}
