class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap();
        for (int i = 0; i < s.length(); i ++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        int maxFreq = Collections.max(hm.values());
        List<Character> [] buckets = new List[maxFreq + 1];

        for (Character c : hm.keySet()) {
            int freq = hm.get(c);
            if (buckets[freq] == null) 
                buckets[freq] = new ArrayList();
            buckets[freq].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int j = buckets.length - 1; j > 0; j --) {
            if (buckets[j] != null) {
                for (Character c : buckets[j]) {
                    for (int i = 0; i < j; i ++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}