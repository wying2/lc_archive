class HitCounter {
    ArrayList<Integer> hits; // storing timestamps
    public HitCounter() {
        this.hits = new ArrayList();
    }
    
    public void hit(int timestamp) {
        this.hits.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        int target = Math.max(0, timestamp - 299);
        int left = 0;
        int right = hits.size() - 1;
        int ind = hits.size();
        // System.out.println(hits);
        // System.out.println("start ind = " + ind);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // System.out.println("hits[mid] = " + hits.get(mid) + " target = " + target);
            // System.out.println(target);
            if (hits.get(mid) >= target) {
                // System.out.println("update right!");
                right = mid - 1;
                ind = mid;
            } else {
                // System.out.println("update left!");
                left = mid + 1;
            }
        }
        // System.out.println("get: " + timestamp + " target: " + target + " found ind :" + ind + " val is: " + hits.get(ind));
        // System.out.println(
        // if (hits.get(ind) == target) ind ++;
        return hits.size() - ind;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */