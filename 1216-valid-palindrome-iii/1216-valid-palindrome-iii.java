class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int len = s.length();
        int[][] dp = new int[len+1][len+1];
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String reversed_s = sb.reverse().toString();
        for (int i = 0; i <= len; i ++ ) {
            for (int j = 0; j <= len; j ++) {
                if (i == 0) 
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (s.charAt(i-1) == reversed_s.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else 
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + 1;
            }
        }
        for (int[] it : dp) {
            System.out.println(Arrays.toString(it));
        }
        return dp[len][len] / 2 <= k ? true : false;
    }
}