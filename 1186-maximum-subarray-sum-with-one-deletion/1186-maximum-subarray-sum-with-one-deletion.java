class Solution {
    public int maximumSum(int[] arr) {
        int[][] dp = new int[arr.length][2];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        for (int i = 1; i < arr.length; i ++) {
            dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i-1][1] + arr[i], dp[i-1][0]);
        }
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < arr.length; j ++) {
            res = Math.max(Math.max(dp[j][0], dp[j][1]), res);
        }
        return res;
    }
}


// arr     status: max sum until curr w no deletion, 1 deletion
// i-1             dp[i-1][0]                        dp[i-1][1]
// i               dp[i-1][0] + nums[i], nums[i]     dp[i-1][1] + nums[i], dp[i-1][0]