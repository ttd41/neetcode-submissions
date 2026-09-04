class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        backtrack(nums, visited, new ArrayList<>());
        return res;

    }

    public void backtrack(int[] nums, boolean[] visited, List<Integer> prev) {
        if (prev.size() == nums.length) {
            res.add(new ArrayList<>(prev));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                prev.add(nums[i]);
                visited[i] = true;
                backtrack(nums, visited, prev);
                visited[i] = false;
                prev.remove(prev.size() - 1);
            }
        }
    }
}
