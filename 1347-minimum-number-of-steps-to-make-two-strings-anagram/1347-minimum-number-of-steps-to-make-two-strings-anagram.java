class Solution {
    public int minSteps(String s, String t) {
        int[] hm = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            hm[s.charAt(i) - 'a'] ++;
            hm[t.charAt(i) - 'a'] --;
        }
        // System.out.println(Arrays.toString(hm));
        int res = 0;
        for (int j = 0; j < 26; j ++) {
            res += Math.max(0, hm[j]);
        }
        return res;
    }
}