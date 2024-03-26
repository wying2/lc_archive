class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < n; i ++) {
        //     System.out.println(arr[i] + ": " + (int)arr[i]);
        // }
        reverse(arr, 0, n-1);
        int counter = 0;
        for (int i = 0; i < n; i ++) {
            System.out.println(arr[i]);
            if (arr[i] == ' ') continue;
            int end = i;
            while (end < n && arr[end] != ' ') {
                // System.out.println((int)arr[end]);
                end ++;
            }
            reverse(arr, i, end-1);
            while (i < end) {
                sb.append(arr[i]);
                i ++;
                counter ++;
            }
            sb.append(' ');
            counter ++;
        }
        // System.out.println(arr);
        return sb.substring(0, counter-1);
    }
    void reverse(char[] arr, int start, int end) {
        while (start <= end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start ++;
            end --;
        }
        // System.out.println(arr);
    }
}