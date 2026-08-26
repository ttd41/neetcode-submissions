
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = len - 1;
            int target = -nums[i];
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    while(j < len - 1 && nums[j] == nums[j + 1]) j++;
                    while(k > 0 && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }

        return res;

    }
}
