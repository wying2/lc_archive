class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 0; i <= l1; i ++) {
            for (int j = 0; j <= l2; j ++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + s2.charAt(j-1);
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + s1.charAt(i-1);
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // the characters might be different!
                    dp[i][j] = Math.min(dp[i][j-1] + s2.charAt(j-1), dp[i-1][j] + s1.charAt(i-1));
                }
            }
        }
        return dp[l1][l2];
    }
}