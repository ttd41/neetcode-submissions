class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> dq = new ArrayDeque<>(k);
        int[] res = new int[len - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i - k + 1 >= 0) {
                while (dq.getFirst() < i - k + 1) {
                    dq.pollFirst();
                }
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
