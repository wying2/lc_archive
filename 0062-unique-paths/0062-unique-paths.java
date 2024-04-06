class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i ++) dp[i] = 1;
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}

// dp[i][j]: possible unique paths to reach grid[i][j]
// size: dp[m][n]
// dp[i][j] = dp[i-1][j] + dp[i][j-1]
// dp[0][j] = 1 dp[i][0] = 1