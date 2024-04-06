class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}

// dp[i][j]: possible unique paths to reach grid[i][j]
// size: dp[m][n]
// dp[i][j] = dp[i-1][j] + dp[i][j-1]
// dp[0][j] = 1 dp[i][0] = 1