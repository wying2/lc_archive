class Solution {
    public int passThePillow(int n, int time) {
        int res = time / (n - 1);
        int rem = time % (n - 1);
        if (res % 2 == 0) {
            return 1 + rem;
        } else {
            return n - rem;
        }
    }
}