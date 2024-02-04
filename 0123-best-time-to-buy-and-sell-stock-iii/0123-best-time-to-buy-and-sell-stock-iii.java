class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0]*2;
        dp[0][3] = 0;
        for (int i = 1; i < prices.length; i ++) {
            dp[i][0] = Math.max(-prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]+prices[i], dp[i-1][1]);
            dp[i][2] = Math.max(dp[i-1][1]-prices[i], dp[i-1][2]);
            dp[i][3] = Math.max(dp[i-1][2]+prices[i], dp[i-1][3]);
        }
        for(int[] it : dp) {
            System.out.println(Arrays.toString(it));
        }
        return Math.max(dp[prices.length-1][1], dp[prices.length-1][3]);
    }
}

// day     status
//         first buy   first sell               second buy                  second sell
// i-1     -price[i-1] max(fb+price[i-1], fs)   max(fb-price[i-1], sb)      max(sb+price[i-1], sc)   