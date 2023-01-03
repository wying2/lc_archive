class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<String>();
        for (String e : emails) {
            String[] ld = e.split("\\@");
            hs.add(ld[0].split("\\+")[0].replaceAll("\\.","")+"@"+ld[1]);
        }
        return hs.size();
    }
}
