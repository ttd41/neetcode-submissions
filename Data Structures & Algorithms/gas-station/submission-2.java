public class Solution {
    // -2, -1, 2, 3
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = n - 1, end = 0;
        int tank = 0;
        while (start >= end) {
            if (tank <= 0) {
                tank += gas[start] - cost[start];
                start--;
            } else {
                tank += gas[end] - cost[end];
                end++;
            }
        }
        return tank >= 0 ? end : -1;
    }
}