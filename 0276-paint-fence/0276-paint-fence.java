class Solution {
    public int numWays(int n, int k) {
        // Base cases for the problem to avoid index out of bound issues
        if (n == 1) return k;
        if (n == 2) return k * k;
        
        // int totalWays[] = new int[n + 1];
        int k1 = k;
        int k2 = k * k;
        
        for (int i = 3; i <= n; i++) {
            int tmp = (k - 1) * (k1 + k2);
            k1 = k2;
            k2 = tmp;
        }
        
        return k2;
    }
}           