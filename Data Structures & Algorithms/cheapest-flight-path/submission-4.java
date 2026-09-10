class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        int MAX = 100 * 10000;
        Arrays.fill(prices, MAX);
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] tempPrices = prices.clone();
            for (int[] f: flights) {
                int u = f[0];
                int v = f[1];
                int w = f[2];

                if (tempPrices[u] + w < prices[v]) {
                    prices[v] = tempPrices[u] + w;
                }
                
            }
        }

        return prices[dst] == MAX ? -1 : prices[dst];


        
    }
}
