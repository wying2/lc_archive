class Solution {
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        return jump(nums, end, end);
    }
    boolean jump (int[] nums, int end, int i) {
        // base case
        if (i == 0) {
            return (nums[i] >= end - i);
        }
        // if can jump
        if (nums[i] >= end - i) {
            end = i;
            return jump(nums, end, i - 1);
        }
        // if cannot jump
        return jump(nums, end, i - 1);
    }
}
