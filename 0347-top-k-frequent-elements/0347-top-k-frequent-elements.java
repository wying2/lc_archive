class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap();
        for (int num : nums) 
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> (pair1[1]-pair2[1]));
        for (Map.Entry<Integer,Integer> entry : hm.entrySet()) {
            if (pq.size() < k)
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            else {
                if (entry.getValue() > pq.peek()[1]) {
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i ++) {
            // System.out.print(pq.peek()[0]);
            // System.out.print(" ");
            // System.out.println(pq.peek()[1]);
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}