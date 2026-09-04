class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();

        backtrack(target, nums, 0, new ArrayList<>());

        return res;
    }

    public void backtrack(int rem, int[] nums, int s, List<Integer> prev) {
        if (rem < 0) {
            return;
        }

        if (rem == 0) {
            res.add(new ArrayList<>(prev));
        }

        for (int i = s; i < nums.length; i++) {
            prev.add(nums[i]);
            backtrack(rem - nums[i], nums, i, prev);
            prev.remove(prev.size() - 1);
        }
    }
}
