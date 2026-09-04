class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {

        res = new ArrayList<>();
        backTracking(nums, 0, new ArrayList<>());

        return res;
        
    }

    public void backTracking(int[] nums, int s, List<Integer> prevNum) {
        res.add(new ArrayList<>(prevNum));
        for (int i = s; i < nums.length; i++) {
            prevNum.add(nums[i]);
            backTracking(nums, i + 1, prevNum);
            prevNum.remove(prevNum.size() - 1);
        }

        return;
    }
}
