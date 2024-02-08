class Solution {
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length()];
        int prev = 1;
        for (int i = s.length() - 1; i >= 0; i --) {
            prev = 1;
            for (int j = t.length() - 1; j >= 0; j --) {
                int old_dpj = dp[j];
                if (s.charAt(i) == t.charAt(j))
                    dp[j] += prev;
                prev = old_dpj;
            }
        }
        return dp[0];
    }
}

// dp[i-1][j-1] => # of subsequences of s[1:i], t[1:j]
// if s[i] == t[j]
// dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
// else
// dp[i][j] = dp[i-1][j]