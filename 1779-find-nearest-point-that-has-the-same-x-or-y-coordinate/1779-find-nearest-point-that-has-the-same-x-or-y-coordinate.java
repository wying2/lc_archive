class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int smallest = Integer.MAX_VALUE;
        int smallest_ind = -1;
        for (int i = points.length - 1; i >= 0; i --) {
            if (points[i][0] == x || points[i][1] == y) {
                int dist = Math.max(Math.abs(points[i][0] - x), Math.abs(points[i][1] - y));
                if (dist <= smallest) {
                    smallest = dist;
                    smallest_ind = i;
                }
            }
        }
        return smallest_ind;
    }
}

// curr = (x, y)
// points[i] = (a, b)
// return smallest index of smallest manhattan