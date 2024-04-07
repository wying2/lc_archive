class Solution {
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int max;
    private int m, n;
    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];
        memo[i][j] = 1;
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= m ||
                nj < 0 || nj >= n ||
                matrix[ni][nj] <= matrix[i][j])
                continue;
            memo[i][j] = Math.max(memo[i][j], 1 + dfs(matrix, ni, nj, memo));
        }
        max = Math.max(max, memo[i][j]);
        return memo[i][j];
    }
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                dfs(matrix, i, j, memo);
            }
        }
        return max;
    }
}