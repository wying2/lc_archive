class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap();
        for (int i = 0; i < s.length(); i ++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        int maxFreq = Collections.max(hm.values());
        List<List<Character>> buckets = new LinkedList();
        for (int i = 0; i <= maxFreq; i ++) {
            buckets.add(new LinkedList());
        }
        for (Character c : hm.keySet()) {
            buckets.get(hm.get(c)).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int j = buckets.size() - 1; j > 0; j --) {
            for (Character c : buckets.get(j)) {
                for (int i = 0; i < j; i ++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}