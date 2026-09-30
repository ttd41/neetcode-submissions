class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int l = i + 1;
            int r = len - 1;

            while (l < r) {
                if (nums[l] + nums[r] < target) {
                    l++;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    if (r == len - 1 || (r < len - 1 && nums[r] != nums[r + 1])) {
                        res.add(List.of(nums[i], nums[l], nums[r]));
                    }
                    l++;
                    r--;
                }
            }


        }

        return res;
    }
}
