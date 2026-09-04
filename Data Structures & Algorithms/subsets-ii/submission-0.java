class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());

        return res;
    }

    public void backtrack(int[] nums, int s, List<Integer> prev) {
        res.add(new ArrayList<>(prev));
        for (int i = s; i < nums.length; i++) {
            if (i > s && nums[i - 1] == nums[i]) {
                continue;
            }
            prev.add(nums[i]);
            backtrack(nums, i + 1, prev);
            prev.remove(prev.size() - 1);

        }
        return;
    }
}
