class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (rooms[i][j] != 0) 
                    continue;
                // if current is gate
                q.offer(new int[]{i, j});
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : DIRS) {
                int ni = curr[0] + dir[0];
                int nj = curr[1] + dir[1];
                int[] new_pair = new int[]{ni, nj};
                if (ni < 0 || ni >= m || 
                    nj < 0 || nj >= n || 
                    rooms[ni][nj] != EMPTY)
                    continue;
                q.offer(new_pair);
                rooms[ni][nj] = rooms[curr[0]][curr[1]] + 1;
            }
        }
    }
}