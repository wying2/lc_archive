class Solution {
    public int totalFruit(int[] fruits) {
        // window size
        int res = 0;
        // store how many different fruits are there in the window
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < fruits.length; ++ i) {
            // put this fruit in to the map
            if (!hm.containsKey(fruits[i]))
                hm.put(fruits[i], 0);
            int tmpVal = hm.get(fruits[i]) + 1;
            hm.put(fruits[i], tmpVal);
            // if less than 2 fruits, grow window
            if (hm.size() <= 2) {
                res ++;
            // else, slide window, handle map, do not grow window
            } else {
                int rm = fruits[i - res];
                int rmVal = hm.get(rm) - 1;
                if (rmVal == 0)
                    hm.remove(rm);
                else
                    hm.put(rm, rmVal);
            }
        }
        return res;
    }
}
