class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // sort jobs by difficulty
        int n = difficulty.length;
        int m = worker.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i ++) {
            jobs[i] = new int[]{difficulty[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> (a[0] - b[0]));
        Arrays.sort(worker);
        // for (int i = 0; i < jobs.length; i ++) {
        //     System.out.println(Arrays.toString(jobs[i]));
        // }
        System.out.println(Arrays.toString(worker));
        int sum = 0;
        int j = -1;
        int max = 0;
        for (int i = 0; i < m; i ++) {
            while (j+1 < n && jobs[j+1][0] <= worker[i]) {
                j ++;
                max = Math.max(max, jobs[j][1]);
            }
            if (j != -1)
                sum += max;
        }
        return sum;
    }
}