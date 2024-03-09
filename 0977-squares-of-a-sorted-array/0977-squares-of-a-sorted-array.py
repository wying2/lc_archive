class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        left = 0
        right = len(nums) -1
        ans = [0] * (right +1)
        ans_pointer = right
        while left <= right:
            if nums[left] * nums[left] >= nums[right] * nums[right]:
                ans[ans_pointer] = nums[left] * nums[left]
                left += 1
            else:
                ans[ans_pointer] = nums[right] * nums[right]
                right -= 1
            ans_pointer -= 1
        return ans