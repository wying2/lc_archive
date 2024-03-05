class Solution(object):
    def ways(self, pizza, k):
        """
        :type pizza: List[str]
        :type k: int
        :rtype: int
        """
        rows = len(pizza)
        cols = len(pizza[0])
        apples = [[0] * (cols + 1) for _ in range(rows + 1)]
        for r in range(rows - 1, -1, -1):
            for c in range(cols - 1, -1, -1):
                apples[r][c] = (pizza[r][c] == 'A') + apples[r+1][c] + apples[r][c+1] - apples[r+1][c+1]
        
        dp = [[[0] * cols for _ in range(rows)] for _ in range(k)]
        
        # dp[0] is the base case, if apples[row][col] has apple, then we can have 1 cut, other wise 0
        dp[0] = [[int(apples[row][col] > 0) for col in range(cols)] for row in range(rows)]
        mod = 1000000007
        for remain in range(1, k):
            for row in range(rows):
                for col in range(cols):
                    val = 0
                    for row_cut in range(row+1, rows):
                        if apples[row][col] > apples[row_cut][col]:
                            val += dp[remain-1][row_cut][col]
                    for col_cut in range(col+1, cols):
                        if apples[row][col] > apples[row][col_cut]:
                            val += dp[remain-1][row][col_cut]
                    dp[remain][row][col] = val % mod
                    # dp[remain][row][col] = val
        return dp[k-1][0][0]
        
        
# remain: k
# base case: k = 0
# # of ways n to cut into k pieces, each piece contain 1 apple
# dp[remain][i][j] -> # of ways n to cut into 