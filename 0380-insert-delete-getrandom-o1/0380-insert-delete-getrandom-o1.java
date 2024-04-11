class RandomizedSet {
    Map<Integer, Integer> val_ind_map;
    List<Integer> ind_val_list;
    Random rand = new Random();

    public RandomizedSet() {
        this.val_ind_map = new HashMap();
        this.ind_val_list = new ArrayList();
    }
    
    public boolean insert(int val) {
        if (val_ind_map.containsKey(val))
            return false;
        int ind = ind_val_list.size();
        ind_val_list.add(val);
        val_ind_map.put(val, ind);
        // System.out.println("insert: " + ind_val_list);
        // System.out.println(val_ind_map.toString());
        return true;
    }
    
    public boolean remove(int val) {
        if (!val_ind_map.containsKey(val))
            return false;
        int ind = val_ind_map.get(val);
        int last_val = ind_val_list.get(ind_val_list.size()-1);
        ind_val_list.set(ind, last_val);
        val_ind_map.put(last_val, ind);
        val_ind_map.remove(val);
        ind_val_list.remove(ind_val_list.size()-1);
        // System.out.println("remove: " + ind_val_list);
        // System.out.println(val_ind_map.toString());
        return true;
    }
    
    
    public int getRandom() {
        return ind_val_list.get(rand.nextInt(ind_val_list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */