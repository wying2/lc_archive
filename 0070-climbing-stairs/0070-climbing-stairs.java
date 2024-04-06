class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[3];
        if (n <= 2) return n;
        for (int i = 1; i <= n; i ++) {
            if (i <= 2) dp[i] = i;
            else {
                int sum = dp[1] + dp[2];
                dp[1] = dp[2];
                dp[2] = sum;
            }
        }
        return dp[2];
    }
}

// dp[i]: how many ways need to reach the ith stair, int[n+1]
// dp[i] = dp[i-1] + dp[i-2]
// dp[0] = 0, dp[1] = 1, dp[2] = 2
