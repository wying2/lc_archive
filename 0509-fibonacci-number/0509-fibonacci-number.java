class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}

// F(n) = F(n-1) + F(n-2)
// dp: storing F(n)