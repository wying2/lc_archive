class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> diffs = new LinkedList();
        for (int i = 0; i < s1.length(); i ++) {
            if (s1.charAt(i) != s2.charAt(i))
                diffs.add(i);
        }
        if (diffs.size() == 0) return true;
        if (diffs.size() == 1) return false;
        if (diffs.size() > 2) return false;
        if (s1.charAt(diffs.get(0)) != s2.charAt(diffs.get(1)) || 
            s1.charAt(diffs.get(1)) != s2.charAt(diffs.get(0)))
            return false;
        return true;
    }
}