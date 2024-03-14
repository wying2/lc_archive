class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(next, needle);
        // System.out.println(Arrays.toString(next));
        int j = 0;
        for (int i = 0; i < haystack.length(); i ++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) return i - j;
                j ++;
            }
        }
        
        return -1;
    }
    
    void getNext (int[] next, String needle) {
        int j = 0;
        next[j] = 0;
        for (int i = 1; i < next.length; i ++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j-1];
            }
            if (needle.charAt(i) == needle.charAt(j))
                j ++;
            next[i] = j;
        }
    }
}