class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        return Math.max(helper(nums, 0, len - 2), helper(nums, 1, len - 1));
    }

    public int helper(int[] nums, int from, int to) {
        int rob1 = 0, rob2 = 0;
        for (int i = from; i <= to; i++) {
            int temp = rob2;
            rob2 = Math.max(nums[i] + rob1, rob2);
            rob1 = temp;
        }

        return rob2;
    }
}
