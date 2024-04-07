class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> diffs = new LinkedList();
        for (int i = 0; i < s1.length(); i ++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffs.add(i);
                if (diffs.size() > 2) return false;
            }
        }
        return diffs.size() == 0 || (diffs.size() == 2 &&
                                    s1.charAt(diffs.get(0)) == s2.charAt(diffs.get(1)) &&
                                    s1.charAt(diffs.get(1)) == s2.charAt(diffs.get(0)));
    }
}