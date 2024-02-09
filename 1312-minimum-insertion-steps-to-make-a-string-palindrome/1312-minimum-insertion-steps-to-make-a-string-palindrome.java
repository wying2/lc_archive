class Solution {
    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len+1][len+1];
        for (int i = 0; i <= len; i ++) {
            for (int j = 0; j <= len; j ++) {
                if (i == 0) 
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (s.charAt(i-1) == s.charAt(len-j))
                    dp[i][j] = dp[i-1][j-1];
                else 
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
            }
        }
        return dp[len][len] / 2;
    }
}