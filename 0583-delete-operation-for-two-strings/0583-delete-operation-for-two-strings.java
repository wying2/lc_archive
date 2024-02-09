class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 0; i <= l1; i ++) {
            for (int j = 0; j <= l2; j ++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[l1][l2];
    }
}


// dp[i][j] => word1[1:i], word2[1:j] minDistance
// dp[i+1][j+1] => word1[1:i+1], word2[1:j+1] minDistance
// if (word1[i+1] = word2[j+1]) => dp[i+1][j+1] = dp[i][j]
// else => min(dp[i][j+1], dp[i+1][j]) + 1