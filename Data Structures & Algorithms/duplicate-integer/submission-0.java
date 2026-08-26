class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (Integer i: nums) {
            if (hs.contains(i)) {
                return true;
            }
            hs.add(i);
        }

        return false;
    }
}