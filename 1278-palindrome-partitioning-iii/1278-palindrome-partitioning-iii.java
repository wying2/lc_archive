class Solution {
    public int palindromePartition(String s, int k) {
        int[][] toPal = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            toPal[i][i] = 0;
        }
        for (int i = s.length() - 1; i >= 0; i --) {
            for (int j = i + 1; j < s.length(); j ++) {
                toPal[i][j] = getChanges(s, i, j);
            }
        }
        int[][] dp = new int[k+1][s.length()];
        for (int i = 0; i < s.length(); i ++) {
            dp[1][i] = toPal[0][i];
        }
        for (int kk = 2; kk <= k; kk ++) {
            for (int end = kk - 1; end < s.length(); end ++) {
                int min = s.length();
                for (int start = end-1; start >= kk-2; start--) {
                    min = Math.min(min, dp[kk-1][start] + toPal[start+1][end]);
                }
                dp[kk][end] = min;
            }
        }
        return dp[k][s.length()-1];
    }
    private int getChanges(String s, int start, int end) {
        // return number of characters that you need to change to 
        // make it Palindrome between i and j
        int changes = 0;
        while(start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                changes++;
            }
        }
        return changes;
    }
}

// dp[i][kk] => given s[1:i], minimal # removed to divide to kk Palindrome
