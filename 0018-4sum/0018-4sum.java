class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int a = 0; a < n - 3; a ++) {
            if (nums[a] > 0 && nums[a] > target) return ans;
            if (a != 0 && nums[a] == nums[a-1]) continue;
            for (int b = a + 1; b < n - 2; b ++) {
                // why this does not work??
                // if (nums[a] + nums[b] > 0 && (nums[a] + nums[b]) > target) return ans;
                if (b != a + 1 && nums[b] == nums[b-1]) continue;
                int c = b + 1;
                int d = n - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum < target) c ++;
                    else if (sum > target) d --;
                    else {
                        ans.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        while (c < d && nums[c] == nums[c + 1]) c ++;
                        while (c < d && nums[d] == nums[d - 1]) d --;
                        c ++;
                        d --;
                    }
                }
            }
        }
        return ans;
    }
}