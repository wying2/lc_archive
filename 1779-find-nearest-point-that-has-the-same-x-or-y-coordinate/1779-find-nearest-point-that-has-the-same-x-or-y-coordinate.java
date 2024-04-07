class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int smallest = Integer.MAX_VALUE;
        int smallest_ind = -1;
        for (int i = points.length - 1; i >= 0; i --) {
            int x_diff = Math.abs(points[i][0] - x);
            int y_diff = Math.abs(points[i][1] - y);
            if (x_diff * y_diff == 0 && Math.max(x_diff, y_diff) <= smallest) {
                smallest = Math.max(x_diff, y_diff);
                smallest_ind = i;
            }
        }
        return smallest_ind;
    }
}

// curr = (x, y)
// points[i] = (a, b)
// return smallest index of smallest manhattan