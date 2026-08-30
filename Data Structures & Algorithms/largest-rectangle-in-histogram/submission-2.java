class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length;
        int res = 0;
        for (int i = 0; i <= len; i++) {
            int ch = i == len ? 0 : heights[i]; //currentHeight
            while (!stack.isEmpty() && heights[stack.peek()] >= ch) {
                int h = heights[stack.pop()];
                int w = i - 1 - (stack.isEmpty() ? -1 : stack.peek());
                res = Math.max(res, h * w);
            }
            stack.push(i);

        }
        

        return res;
    }
}
