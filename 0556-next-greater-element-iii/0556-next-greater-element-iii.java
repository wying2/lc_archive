class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> digits_list = new ArrayList();
        int t = n;
        while (t != 0) {
            digits_list.add(t % 10);
            t = t / 10;
        }
        int[] digits = new int[digits_list.size()];
        for (int i = 0; i < digits_list.size(); i ++) {
            digits[i] = digits_list.get(i);
        }
        if (digits.length == 1)
            return -1;
        boolean found = false;
        System.out.println(Arrays.toString(digits));
        for (int fast = 1; fast < digits.length; fast ++) {
            if (digits[fast] < digits[fast - 1]) {
                int j = fast;
                while (j >= 1 && digits[j-1] > digits[fast]) {
                    j --;
                }
                System.out.println("j = " + j);
                int tmp = digits[fast];
                digits[fast] = digits[j];
                digits[j] = tmp;
                System.out.println(Arrays.toString(digits));
                reverse(0, fast-1, digits);
                found = true;
                break;
            } 
        }
        if (!found) return -1;
        int res = 0;
        System.out.println(Integer.MAX_VALUE);
        for (int i = digits.length - 1; i >= 0; i --) {
            System.out.println(res);
            if (res > Integer.MAX_VALUE / 10)
                return -1;
            if (res == Integer.MAX_VALUE / 10 && digits[i] > 7)
                return -1;
            res = res * 10 + digits[i];
        }
        return res;
    }
    private void reverse(int left, int right, int[] digits) {
        while (left < right) {
            int tmp = digits[left];
            digits[left] = digits[right];
            digits[right] = tmp;
            left ++;
            right --;
        }
    }
}

// 1234
// 4,3,2,1 -> 
