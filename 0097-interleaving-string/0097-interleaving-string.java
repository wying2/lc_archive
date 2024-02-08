class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length(); i ++) {
            for (int j = 0; j <= s2.length(); j ++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = (s2.charAt(j-1) == s3.charAt(i + j - 1) && dp[i][j-1]);
                else if (j == 0)
                    dp[i][j] = (s1.charAt(i-1) == s3.charAt(i + j - 1) && dp[i-1][j]);
                else 
                    dp[i][j] = (s2.charAt(j-1) == s3.charAt(i + j - 1) && dp[i][j-1]) || 
                               (s1.charAt(i-1) == s3.charAt(i + j - 1) && dp[i-1][j]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}

// dp[i][j] => s1[1:i], s2[1:j] isInterleave s3[1:i+j]
// dp[i][j] => if s1[i] == s3[i+j] => check dp[i-1][j]