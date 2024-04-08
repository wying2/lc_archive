class Solution {
    static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        // int[][] visited = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid2[i][j] == 0)
                    continue;
                // System.out.println("i = " + i + " j = " + j);
                // boolean tmp = bfs(visited, grid1, grid2, i, j);
                // System.out.println("bfs = " + tmp);
                boolean tmp = dfs(grid1, grid2, i, j);
                if (tmp) {
                    count += 1;
                }
            }
        }
        return count;
    }
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        grid2[i][j] = 0;
        boolean contains_all = grid1[i][j] == 1;
        int m = grid1.length;
        int n = grid1[0].length;
        for (int[] dir : this.dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= m ||
                nj < 0 || nj >= n ||
                grid2[ni][nj] == 0)
                continue;
            contains_all &= dfs(grid1, grid2, ni, nj);
        }
        return contains_all;
    }
    private boolean bfs(int[][] visited, int[][] grid1, int[][] grid2, int i, int j) {
        boolean contains_all = true;
        int m = grid1.length;
        int n = grid1[0].length;
        Queue<int[]> q = new LinkedList();
        contains_all = grid1[i][j] == 1;
        q.offer(new int[]{i, j});
        visited[i][j] = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k ++) {
                int[] curr = q.poll();
                for (int[] dir : this.dirs) {
                    int ni = curr[0] + dir[0];
                    int nj = curr[1] + dir[1];
                    if (ni < 0 || ni >= m ||
                        nj < 0 || nj >= n ||
                        visited[ni][nj] == 1 ||
                        grid2[ni][nj] == 0)
                        continue;
                    if (grid1[ni][nj] == 0) contains_all = false;
                    q.offer(new int[]{ni, nj});
                    visited[ni][nj] = 1;
                }
            }
        }
        return contains_all;
    }
}