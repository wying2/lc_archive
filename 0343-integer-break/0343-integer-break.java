class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 0; i <= n; i ++) {
            for (int j = 0; j < i; j ++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i-j), dp[j]*(i-j)));
            }
            // System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }
}

// dp[i]: max product i can get for i break
// size: n
// dp[i] = max (foreach j in range i, dp[j] * (i-j))
// dp[0] = 0
// dp[1] = 1
// dp[2] = 1
// dp[3] = 2
// dp[4] = 3
// dp[5] = 6