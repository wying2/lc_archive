class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for (int j = 0; j < k; j ++) {
            dp[0][j] = costs[0][j];
        }
        for (int i = 1; i < costs.length; i ++) {
            for (int m = 0; m < k; m ++) {
                int min = Integer.MAX_VALUE;
                for (int p = 0; p < k; p ++) {
                    if (p != m) min = Math.min(dp[i-1][p] + costs[i][m], min);
                }
                dp[i][m] = min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int c : dp[n-1]) {
            res = Math.min(c, res);
        }
        return res;
    }
}