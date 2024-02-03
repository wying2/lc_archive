class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max_prof = 0;
        for (int i = 0; i < prices.length; i ++) {
            min = Math.min(prices[i], min);
            max_prof = Math.max(prices[i] - min, max_prof);
        }
        return max_prof;
    }
}