class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i ++) {
            for (int j = 0; j < t.length(); j ++) {
                if (i == 0 && j == 0)
                    dp[i][j] = s.charAt(i) == t.charAt(j) ? 1 : 0;
                else if (i == 0)
                    dp[i][j] = 0;
                else if (j == 0){
                    if (s.charAt(i) == t.charAt(j))
                        dp[i][j] = dp[i-1][j] + 1;
                    else
                        dp[i][j] = dp[i-1][j];
                }
                else {
                    if (s.charAt(i) == t.charAt(j))
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()-1][t.length()-1];
    }
}

// dp[i-1][j-1] => # of subsequences of s[1:i], t[1:j]
// if s[i] == t[j]
// dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
// else
// dp[i][j] = dp[i-1][j]