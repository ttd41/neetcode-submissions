class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> dq = new ArrayDeque<>();
        int len = temperatures.length;
        int[] res = new int[len];


        for (int i = 0; i < len; i++) {
            while (!dq.isEmpty() && temperatures[dq.peek()] < temperatures[i]) {
                int prev = dq.pop();
                res[prev] = i - prev;
            }
            dq.push(i);
        }

        return res;
    }
}
