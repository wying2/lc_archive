class Solution:
    def largestSumOfAverages(self, nums: List[int], k: int) -> float:
        n = len(nums)
        dp = [[0] * (n+1) for _ in range(k)]
        
        def ave(a, b):
            return sum(nums[a:b]) / len(nums[a:b])
        
        for i in range(1, n+1):
            for K in range(min(i,k)):
                if K == 0:
                    dp[K][i] = ave(0, i) 
                elif i > K:
                    for j in range(i):
                        dp[K][i]=max(dp[K-1][j]+ave(j,i),dp[K][i])
            # print(dp)
        
        return dp[k-1][n]