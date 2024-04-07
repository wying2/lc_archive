class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // sort jobs
        int len = startTime.length;
        int[][] jobs = new int[len][3];
        for (int i = 0; i < len; i ++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> (a[1] - b[1]));
        // for (int i = 0; i < len; i ++) 
        //     System.out.println(Arrays.toString(jobs[i]));
        // dp
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i ++) {
            int j;
            for (j = Math.max(0, i-1); j >= 1; j --) {
                if (jobs[j-1][1] <= jobs[i-1][0])
                    break;
            }
            // System.out.println("i = " + Arrays.toString(jobs[i-1]));
            // System.out.println("j = " + dp[j]);
            dp[i] = Math.max(dp[i-1], dp[j] + jobs[i-1][2]);
            // System.out.println(Arrays.toString(dp));
        }
        return dp[len];
    }
}


// job: select, not select
// dp[i]: max profit if select or not select (i-1)th
// size: len(startTime)+1
// dp[i] = max(dp[i-1], dp[k, where endtime[k] is smaller than starttime[i-1]] + profit[i-1])
