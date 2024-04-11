class ListNode {
    int val;
    int key;
    ListNode prev;
    ListNode next;
    
    ListNode(int val, int key) {
        this.val = val;
        this.key = key;
    }
    
    ListNode() {
        this.val = -1;
        this.key = -1;
    }
}

class LRUCache {
    HashMap<Integer, ListNode> cache;
    ListNode head; // add from head
    ListNode tail; // remove from tail
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap();
        this.head = new ListNode();
        this.tail = new ListNode();
        head.next = tail;
        tail.prev = head;
        this.size = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        ListNode node = cache.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        // System.out.println("size = "+size+" capacity = "+capacity);
        // System.out.println(cache.toString());
        if (cache.containsKey(key)) {
            ListNode hit = cache.get(key);
            hit.val = value;
            hit.key = key;
            hit.prev.next = hit.next;
            hit.next.prev = hit.prev;
            addToHead(hit);
        } else {
            if (size == capacity) {
                evictFromTail();
            }
            ListNode newNode = new ListNode(value, key);
            addToHead(newNode);
            cache.put(key, newNode);
            size ++;
        }
        // System.out.println("size = "+size+" capacity = "+capacity);
        // System.out.println(cache.toString());
    }
    
    private void addToHead(ListNode hit) {
        ListNode sec = head.next;
        head.next = hit;
        sec.prev = hit;
        hit.next = sec;
        hit.prev = head;
    }
    
    private void evictFromTail() {
        ListNode sec = tail.prev;
        sec.prev.next = tail;
        tail.prev = sec.prev;
        cache.remove(sec.key);
        size --;
    }
}

// HashMap

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */