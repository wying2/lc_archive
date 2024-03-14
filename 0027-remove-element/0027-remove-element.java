class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        int ans = 0;
        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == val) {
                fast ++;
            }
            if (fast >= nums.length) break;
            nums[slow] = nums[fast];
            slow ++;
            fast ++;
            ans ++;
        }
        return ans;
    }
}