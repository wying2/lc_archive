class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++ i) {
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++ j) {
                    int comp = -nums[i] - nums[j];
                    if (seen.containsKey(comp) && seen.get(comp) == i) {
                        List<Integer> triple = Arrays.asList(nums[i], nums[j], comp);
                        Collections.sort(triple);
                        res.add(triple);
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return new ArrayList(res);
    }
}
