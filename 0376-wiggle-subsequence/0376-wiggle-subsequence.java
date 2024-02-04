class Solution {
    public int wiggleMaxLength(int[] nums) {
        int dp00 = 1;
        int dp10 = 1;
        for (int i = 1; i < nums.length; i ++) {
            int dp0i = dp00;
            int dp1i = dp10;
            if (nums[i] - nums[i-1] > 0) {
                dp0i = dp10 + 1;
            }
            if (nums[i] - nums[i-1] < 0) {
                dp1i = dp00 + 1;
            } 
            dp10 = dp1i;
            dp00 = dp0i;
        }
        return Math.max(dp10, dp00);
    }
}

// num     status: wiggle up    down             