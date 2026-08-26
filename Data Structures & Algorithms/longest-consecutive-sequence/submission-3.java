class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int n: nums) {
            hs.add(n);
        }
        int max = 0;
        for (int curr: nums) {
            if (!hs.contains(curr - 1)) {
                int c = curr;
                int l = 0;
                while (hs.contains(c)) {
                    l++;
                    c++;
                }
                max = Math.max(l, max);
            }
        }
        return max;
    }

}
