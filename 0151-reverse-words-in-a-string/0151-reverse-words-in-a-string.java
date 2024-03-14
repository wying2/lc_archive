class Solution {
    public String reverseWords(String s) {
        char[] s_arr = s.toCharArray();
        // char[] ans = new char[s.length()];
        int l = 0;
        int r = s_arr.length - 1;
        reverse(s_arr, l, r);
        int slow = 0;
        for (int i = 0; i < s_arr.length; i ++) {
            // remove space
            if (s_arr[i] == ' ') {
                continue;
            }
            int start = i;
            while (i < s_arr.length && s_arr[i] != ' ') {
                i ++;
            }
            reverse(s_arr, start, i-1);
            for (int j = start; j < i; j ++) {
                s_arr[slow++] = s_arr[j];
                if (j == i-1 && slow < s_arr.length) {
                    s_arr[slow++] = ' ';
                }
            }
        }
        return new String(s_arr, 0, (slow == s_arr.length) && (s_arr[slow - 1] != ' ') ? slow : slow - 1);
    }
    
    public void reverse (char[] s_arr, int start, int end) {
        for (int l = start, r = end; l < r; l ++, r --) {
            s_arr[l] ^= s_arr[r];
            s_arr[r] ^= s_arr[l];
            s_arr[l] ^= s_arr[r];
        }
    }
}