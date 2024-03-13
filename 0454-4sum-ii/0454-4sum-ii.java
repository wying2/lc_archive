class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums1.length; i ++) {
            for (int j = 0; j < nums2.length; j ++) {
                hm.put(nums1[i]+nums2[j], hm.getOrDefault(nums1[i]+nums2[j], 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < nums3.length; i ++) {
            for (int j = 0; j < nums4.length; j ++) {
                if (hm.containsKey(0 - nums3[i] - nums4[j]))
                    count += hm.get(0 - nums3[i] - nums4[j]);
            }
        }
        return count;
    }
}