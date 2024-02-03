class Solution {
    public int maxProfit(int[] prices) {
        int max_prof = 0;
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] > prices[i - 1])
                max_prof += prices[i] - prices[i-1];
        }
        return max_prof;
    }
}

// day i   0           1
// 0       0           -7
// 1       max(0, 0)   max(-prices[1], dp[0][1])