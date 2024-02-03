class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max_prof = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] < min) min = prices[i];
            System.out.println(min);
            if (prices[i] - min > max_prof) max_prof = prices[i] - min;
        }
        return max_prof;
    }
}