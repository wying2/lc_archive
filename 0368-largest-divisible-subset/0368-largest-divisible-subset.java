class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList();
        List<ArrayList<Integer>> dp = new ArrayList();
        for (int i = 0; i < n; i ++) 
            dp.add(new ArrayList());
        Arrays.sort(nums);
        for (int i = 0; i < n; i ++) {
            ArrayList<Integer> tmp = new ArrayList();
            for (int j = 0; j < i; j ++) {
                if (nums[i] % nums[j] == 0 && tmp.size() < dp.get(j).size())
                    tmp = dp.get(j);
                    // note: tmp is pointing to the actual dp.get(j), instead of a new Arraylist
            }
            // which means, if you first add the current element to tmp
            // it would be added to dp.get(j) as well
            // and when we try to get it for the next time, the list is not correct
            dp.get(i).addAll(tmp);
            dp.get(i).add(nums[i]);
        }
        List<Integer> ret = new ArrayList();
        for (int k = 0; k < n; k ++) {
            if (ret.size() < dp.get(k).size())
                ret = dp.get(k);
        }
        return ret;
    }
}