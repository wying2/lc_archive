class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i ++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}

// dp[i]: how many ways need to reach the ith stair, int[n+1]
// dp[i] = dp[i-1] + dp[i-2]
// dp[0] = 0, dp[1] = 1, dp[2] = 2
