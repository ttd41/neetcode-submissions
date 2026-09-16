class Solution {
    public int maxSubArray(int[] nums) {
        int res = -10000;
        int maxSum = 0;

        for (int num: nums) {
            if (maxSum < 0) {
                maxSum = num;
            } else {
                maxSum += num;
            }
            res = Math.max(maxSum, res);
        }

        return res;
    }
}
