class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i ++) {
            for (int j = 0; j <= l2; j ++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = l1;
        int j = l2;
        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            } else {
                if (dp[i][j] == dp[i-1][j] + 1) {
                    sb.append(str1.charAt(i-1));
                    i--;
                } else if (dp[i][j] == dp[i][j-1] + 1) {
                    sb.append(str2.charAt(j-1));
                    j--;
                }
            }
        }
        for (int ii = i; i > 0; i --) {
            sb.append(str1.charAt(i-1));
        }
        for (int jj = j; j > 0; j --) {
            sb.append(str2.charAt(j-1));
        }
        return sb.reverse().toString();
    }
}