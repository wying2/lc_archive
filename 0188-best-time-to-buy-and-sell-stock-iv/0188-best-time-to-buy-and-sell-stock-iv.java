class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k*2];
        for (int i = 0; i < k*2; i ++) {
            if (i % 2 == 0) dp[0][i] = -prices[0];
            else dp[0][i] = 0;
        }
        for (int j = 1; j < prices.length; j ++) {
            dp[j][0] = Math.max(-prices[j], dp[j-1][0]);
            for (int i = 1; i < k*2; i ++) {
                if (i%2 == 1)
                    dp[j][i] = Math.max(dp[j-1][i-1]+prices[j], dp[j-1][i]);
                if (i%2 == 0)
                    dp[j][i] = Math.max(dp[j-1][i-1]-prices[j], dp[j-1][i]);
            }
        }
        
        int max = 0;
        for (int m : dp[prices.length-1]) {
            max = Math.max(max, m);
        }
        return max;
    }
}