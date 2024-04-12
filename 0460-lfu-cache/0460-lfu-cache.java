class LFUCache {
    
    HashMap<Integer, Pair<Integer, Integer>> cache; // key, (val, count)
    HashMap<Integer, LinkedHashSet<Integer>> frequency; // count, keys(insertion order)
    int capacity;
    int min_freq;
    
    public LFUCache(int capacity) {
        this.cache = new HashMap();
        this.frequency = new HashMap();
        this.capacity = capacity;
        this.min_freq = 0;
    }
    
    private void insert(int key, int frequency, int val) {
        this.cache.put(key, new Pair<>(val, frequency));
        this.frequency.putIfAbsent(frequency, new LinkedHashSet());
        this.frequency.get(frequency).add(key);
    }
    
    public int get(int key) {
        Pair<Integer, Integer> hit = this.cache.get(key);
        if (hit == null) return -1;
        int val = hit.getKey();
        int count = hit.getValue();
        LinkedHashSet<Integer> keys = this.frequency.get(count);
        keys.remove(key);
        if (keys.size() == 0) {
            frequency.remove(count);
            if (min_freq == count)
                min_freq ++;
        }
        insert(key, count+1, val);
        return val;
    }
    
    public void put(int key, int value) {
        Pair<Integer, Integer> hit = this.cache.get(key);
        if (hit == null) {
            if (this.cache.size() == this.capacity) {
                LinkedHashSet<Integer> keys = frequency.get(min_freq);
                int key_to_delete = keys.iterator().next();
                cache.remove(key_to_delete);
                keys.remove(key_to_delete);
                if (keys.size() == 0)
                    frequency.remove(min_freq);
            }
            min_freq = 1;
            insert(key, 1, value);
        } else {
            cache.put(key, new Pair<>(value, hit.getValue()));
            get(key);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */