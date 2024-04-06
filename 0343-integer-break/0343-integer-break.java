class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i ++) {
            for (int j = 1; j <= i-j; j ++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
            // System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }
}

// dp[i]: max product i can get for i break
// size: n
// dp[i] = max (foreach j in range i, dp[j] * (i-j), j * (i-j))
// dp[0] = 0
// dp[1] = 1
// dp[2] = 1
// dp[3] = 2
// dp[4] = 3
// dp[5] = 6