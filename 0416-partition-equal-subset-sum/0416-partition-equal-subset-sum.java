class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int len = nums.length;
        int dp[] = new int[sum / 2 + 1];
        // System.out.println(Arrays.toString(dp[0]));
        // System.out.println(dp[0].length);
        for (int i = 1; i < len; i ++) {
            for (int j = sum/2; j-nums[i] >= 0; j --) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
            // System.out.println(Arrays.toString(dp[i]));
        }
        return dp[sum/2] == sum/2;
    }
}

// dp[i][j]: i: the ith number, j: sum, storing max val can be taken smaller than j
// dp[nums.length][sum / 2]
// dp[i][j] = max(dp[i-1][j], dp[j-nums[i]]+nums[i])
// dp[0][j] = false