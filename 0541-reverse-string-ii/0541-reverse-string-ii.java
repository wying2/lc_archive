class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] s_arr = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2*k) {
            int left = i;
            int right = Math.min(left + k - 1, s.length() - 1);
            while (left < right) {
                s_arr[left] ^= s_arr[right];
                s_arr[right] ^= s_arr[left];
                s_arr[left] ^= s_arr[right];
                left ++;
                right --;
            }
        }
        sb.append(s_arr);
        return sb.toString();
    }
}