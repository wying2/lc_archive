class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length -1;
        int ind = nums.length -1;
        while (left <= right) {
            int left_pow = nums[left] * nums[left];
            int right_pow = nums[right] * nums[right];
            if (left_pow > right_pow) {
                ans[ind] = left_pow;
                left ++;
            } else {
                ans[ind] = right_pow;
                right --;
            }
            ind --;
        }
        return ans;
    }
}