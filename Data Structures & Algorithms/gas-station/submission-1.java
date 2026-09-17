class Solution {
    // [3, -1, -3, 2]
    // [-1, -3, 2, 3]
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int total = 0;
        int totalRem = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int cur = gas[i] - cost[i];
            total += cur;
            totalRem += cur;
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }

        return totalRem < 0 ? -1 : res;
    }
}
