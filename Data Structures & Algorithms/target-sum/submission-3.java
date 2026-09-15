class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int i = 0; i < len; i++) {
            Map<Integer, Integer> newMap = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry: dp.entrySet()) {
                newMap.put(entry.getKey() - nums[i], newMap.getOrDefault(entry.getKey() - nums[i], 0) + entry.getValue());
                newMap.put(entry.getKey() + nums[i], newMap.getOrDefault(entry.getKey() + nums[i], 0) + entry.getValue());
            }
            dp = newMap;
        }

        return dp.getOrDefault(target, 0);
    }
}
