class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len + 1][3];
        // 0 rest 1 hold 2 sell
        int rest = 0;
        int hold = -prices[0];
        int sell = 0;
        for (int i = 1; i < len; i++) {
            int restp = rest;
            int holdp = hold;
            int sellp = sell;
            for (int j = 0; j < 3; j++) {
                rest = Math.max(restp, sellp);
                hold = Math.max(holdp, restp - prices[i]);
                sell = holdp + prices[i];
            }
        }

        return Math.max(rest, sell);
    }
}
