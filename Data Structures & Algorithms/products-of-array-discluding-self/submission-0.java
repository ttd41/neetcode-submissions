class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefixP = new int[len];
        int[] suffixP = new int[len];
        int pre = 1;
        prefixP[0] = 1;
        suffixP[len - 1] = 1;
        for (int i = 0; i < len - 1; i++) {
            pre *= nums[i];
            prefixP[i + 1] = pre;
        }
        int suf = 1;
        for (int i = len - 1; i > 0; i--) {
            suf *= nums[i];
            suffixP[i - 1] = suf;
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = prefixP[i] * suffixP[i];
        }

        return res;
    }
}  
