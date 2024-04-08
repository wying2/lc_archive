class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i ++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> (a[1] - b[1]));
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i ++) {
            int k = binarySearch(jobs, i-1, jobs[i-1][0]);
            dp[i] = Math.max(dp[i-1], dp[k+1] + jobs[i-1][2]);
        }
        return dp[n];
    }
    private int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left - 1;
    }
}

// jobs: starttime, endtime, profit
// jobs[i] : select, not select
// dp[i]: from in total of i jobs, the max profit
// return dp[n]
// dp size n+1
// dp[i] = max(dp[i-1], dp[k] + profit[i-1])
// k: the num of jobs, where the last job k-1 ends before i-1
// dp[0] = 0
// dp[1] = max(0, profit[i-1])