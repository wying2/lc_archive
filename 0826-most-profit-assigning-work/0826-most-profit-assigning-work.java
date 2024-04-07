class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int size = (int)Math.pow(10, 5) + 1;
        int[] dp = new int[size];
        for (int i = 0; i < difficulty.length; i ++) {
            dp[difficulty[i]] = Math.max(dp[difficulty[i]], profit[i]);
        }
        for (int i = 1; i < size; i ++) {
            dp[i] = Math.max(dp[i-1], dp[i]);
        }
        int sum = 0;
        for (int i = 0; i < worker.length; i ++) {
            sum += dp[worker[i]];
        }
        return sum;
    }
}

// dp[i]: max profit for 1 job for ability i
// size: 10 ** 5 + 1
// for i in difficulty: dp[i] = max(profit[i])
// dp[i] = max(dp[i], dp[i-1])
// return sum(dp[j] for j in worker)