class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        int res = 1;
        // a map, storing <arr[i], i>
        // used to check if there is a higher or lower value after i
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // dp, storing if arr[i] can jump higher or lower
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        // can always jump either higher or lower at the end
        higher[n - 1] = true;
        lower[n - 1] = true;
        map.put(arr[n - 1], n - 1);
        for (int i = n - 2; i >= 0; --i) {
            int key = arr[i];
            // get least key greater than or equal to the arr[n]
            // or null if there is no such key.
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(key);
            // get greatest key less than or equal to the arr[n]
            // or null if there is no such key.
            Map.Entry<Integer, Integer> lo = map.floorEntry(key);
            // if hi != null means there is a higher value to jump
            if (hi != null) {
                // however, cannot jump if there is no next jump
                higher[i] = lower[hi.getValue()];
            }
            // if lo != null means there is a lower value to jump
            if (lo != null) {
                // however, cannot jump if there is no next jump
                lower[i] = higher[lo.getValue()];
            }
            // we can only jump starting with an odd step (1 is odd)
            if (higher[i]) res ++;
            map.put(key, i);
        }
        return res;
    }
}
