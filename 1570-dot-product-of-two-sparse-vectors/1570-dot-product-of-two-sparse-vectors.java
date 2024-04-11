class SparseVector {
    HashMap<Integer, Integer> ind_val;
    
    SparseVector(int[] nums) {
        this.ind_val = new HashMap();
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) continue;
            this.ind_val.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for (Integer i : this.ind_val.keySet()) {
            if (vec.ind_val.containsKey(i))
                res += this.ind_val.get(i) * vec.ind_val.get(i);
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);