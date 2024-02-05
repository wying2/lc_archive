class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0] == 0 ? 0 : 1;
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == 1) {
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1] + 1;
            } else {
                dp[i][0] = 0;
                dp[i][1] = dp[i-1][0] + 1;
                // dp[i][1] = Math.max(dp[i-1][0] + 1, dp[i-1][1]);
            }
        }
        // for (int[] it : dp) {
        //     System.out.println(Arrays.toString(it));
        // }
        int res = 0;
        for (int j = 0; j < nums.length; j ++) {
            res = Math.max(res, dp[j][1]);
        }
        return res;
    }
}


// nums    status: not flipped, flipped
// i-1             dp[i-1][0]   dp[i-1][1]
// i            1  dp[i-1][0]+1 dp[i-1][1]+1
// i            0  0            dp[i-1][1]+1