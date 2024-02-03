class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        // int[] dp = new int[nums.length];
        int dp0 = nums[0];
        int dp1 = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i ++) {
            int tmp = Math.max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = tmp;
        }
        return dp1;
    }
}
