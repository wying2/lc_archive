class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        int ini_path = 1;
        for (int i = 0; i < n; i ++) {
            if (obstacleGrid[0][i] == 1) {
                ini_path = 0;
            } 
            dp[i] = ini_path;
        }
        // System.out.println(Arrays.toString(dp));
        for (int j = 1; j < m; j ++) {
            for (int i = 0; i < n; i ++) {
                if (obstacleGrid[j][i] == 1) dp[i] = 0;
                else {
                    if (i != 0) dp[i] += dp[i-1];
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}