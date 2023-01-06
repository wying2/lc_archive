class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; // keep track of leftmost index
        int right = 0; // keep track of rightmost index
        int max = 0;
        HashMap<Character, Integer> hm = new HashMap<>(); // keep track of index of elements
        for (int i = 0; i < s.length(); ++ i) {
            // if already recorded this element 
            // and the index of it is in the window
            if (hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i)) >= left) {
                int tmp = hm.get(s.charAt(i));
                left = ++ tmp;
            }
            hm.put(s.charAt(i), i);
            right ++;
            max = Math.max(max, right-left);
        }
        return max;
    }
}
