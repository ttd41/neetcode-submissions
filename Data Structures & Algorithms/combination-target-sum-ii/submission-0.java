class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList();
        Arrays.sort(candidates);

        backtrack(candidates, 0, target, new ArrayList<>());

        return res;
        
    }

    public void backtrack(int[] candidates, int s, int rem, List<Integer> prev) {
        if (rem == 0) {
            res.add(new ArrayList<>(prev));
            return;
        }

        if (rem < 0) {
            return;
        }

        for (int i = s; i < candidates.length; i++) {
            if (i >= s + 1 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            prev.add(candidates[i]);
            backtrack(candidates, i + 1, rem - candidates[i], prev);
            prev.remove(prev.size() - 1);
        }

        return;
    }
}
