class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        for (int n: nums) {
            if (!map.containsKey(n)) {
                map.put(n, map.getOrDefault(n - 1, 0) + 1 + map.getOrDefault(n + 1, 0));
                map.put(n - map.getOrDefault(n - 1, 0), map.get(n));
                map.put(n + map.getOrDefault(n + 1, 0), map.get(n));    
                res = Math.max(res, map.get(n));
            }
        }

        return res;
    }
}
