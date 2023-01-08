class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        int c = 0;
        int ind = 0;
        for (int i = num1.length() - 1; i >= 0; -- i) {
            int num1tmp = num1.charAt(i) - 48;
            c = 0;
            // System.out.println("c: " + c);
            // System.out.println("num1 element: " + num1tmp);
            for (int j = num2.length() - 1; j >= 0; -- j) {
                ind = (res.length - 1) - ((num1.length() - 1 - i) + (num2.length() - 1 - j));
                // System.out.println("res ind: " + ind);
                int num2tmp = num2.charAt(j) - 48;
                // System.out.println("num2 element: " + num2tmp);
                int multitmp = res[ind] + num1tmp * num2tmp + c;
                // System.out.println("res[ind]: " + res[ind]);
                // System.out.println("c: " + c);
                // System.out.println("multitmp: " + multitmp);
                res[ind] = multitmp % 10;
                c = multitmp / 10;
            }
            if (c != 0)
                res[ind - 1] = c;
        }
        StringBuilder stringb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            stringb.append(res[i]);
        }
        for (int k = 0; k < stringb.length(); ++k) {
            if (stringb.charAt(k) != '0') {
                String r = stringb.substring(k);
                return r;
            }
        }
        return "0";
    }
}
