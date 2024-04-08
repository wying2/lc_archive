class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0; i < piles.length; i ++)
            max = Math.max(max, piles[i]);
        int res = binarySearch(piles, max, h);
        // System.out.println(max);
        return res;
    }
    
    private int binarySearch(int[] piles, int right, int h) {
        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int i = 0; i < piles.length; i ++) {
                hours += piles[i] / mid;
                if (piles[i] % mid != 0)
                    hours ++;
            }
            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

// hours to finish: pile[i] / can_k + 1
// sum <= h