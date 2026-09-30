class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int n: nums) {
            hs.add(n);
        }

        int res = 0;
        for (int n: hs) {
            if (!hs.contains(n - 1)) {
                int len = 1;
                while (hs.contains(n + len)) {
                    len++;
                }
                res = Math.max(res, len);
            }
        }

        return res;
    }
}
