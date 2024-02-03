class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        // if (nums.length <= 3) {
        //     Arrays.sort(nums);
        //     return nums[nums.length - 1];
        // }
        // int[] dp1 = new int[nums.length - 1];
        // int[] dp2 = new int[nums.length - 1];
        int dp10 = nums[0];
        int dp11 = Math.max(nums[0], nums[1]);
        int dp20 = nums[1];
        int dp21 = Math.max(nums[1], nums[2]);
        for (int i = 2; i < nums.length - 1; i ++) {
            int dp1i = Math.max(dp10 + nums[i], dp11);
            int dp2i = Math.max(dp20 + nums[i + 1], dp21);
            dp10 = dp11;
            dp11 = dp1i;
            dp20 = dp21;
            dp21 = dp2i;
        }
        return Math.max(dp11, dp21);
    }
}