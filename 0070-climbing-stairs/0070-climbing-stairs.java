class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if (n <= 2) return n;
        for (int i = 0; i <= n; i ++) {
            if (i <= 2) dp[i] = i;
            else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
}

// dp[i]: how many ways need to reach the ith stair, int[n+1]
// dp[i] = dp[i-1] + dp[i-2]
// dp[0] = 0, dp[1] = 1, dp[2] = 2
