class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm =  new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            if (hm.containsKey(v)) {
                return new int[]{hm.get(v), i};
            }
            hm.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
