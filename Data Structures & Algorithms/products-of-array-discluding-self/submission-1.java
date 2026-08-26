class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefixP = new int[len];
        prefixP[0] = 1;
        for (int i = 0; i < len - 1; i++) {
            prefixP[i + 1] = nums[i] * prefixP[i];
        }
        int suffix = 1;
        for (int i = len - 1; i >= 0; i--) {
            prefixP[i] *= suffix;
            suffix *= nums[i];
        }

        return prefixP;
    }
}  
