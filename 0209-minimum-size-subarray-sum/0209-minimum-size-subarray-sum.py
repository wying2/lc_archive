class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        ans = sys.maxsize
        left = 0
        summ = 0
        for right in range(len(nums)):
            summ += nums[right]
            while summ >= target:
                ans = min(ans, right - left + 1)
                summ -= nums[left]
                left += 1
        if ans == sys.maxsize:
            ans = 0
        return ans