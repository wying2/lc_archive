class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String[] tmp = s.split("-");
        String res = "";
        int rem = k;
        for (int i = tmp.length - 1; i >= 0; --i) {
            tmp[i] = tmp[i].toUpperCase();
            while (tmp[i].length() >= rem) {
                String tmps = tmp[i].substring(tmp[i].length() - rem);
                res = "-" + tmps + res;
                tmp[i] = tmp[i].substring(0, tmp[i].length() - rem);
                rem = k;
            }
            res = tmp[i] + res;
            rem = rem - tmp[i].length();
        } 
        if (res != "" && res.charAt(0) == '-')
            res = res.substring(1);
        return res;
    }
}
