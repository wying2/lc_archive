class Solution {
    class MonoQueue {
        Deque<Integer> queue;
        // int front;
        public MonoQueue () {
            this.queue = new LinkedList();
            // this.front = - 100001;
        }
        public void push(int i) {
            while (!queue.isEmpty() && queue.getLast() < i) {
                queue.removeLast();
            }
            queue.add(i);
            // front = queue.peekLast();
        }
        public void pop(int i) {
            if (!queue.isEmpty() && queue.peek() == i) {
                queue.pop();
                // front = queue.peekLast();
            }
        }
        public int front() {
            return queue.peek();
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        // int[] res = new int[nums.length-k+1];
        ArrayList<Integer> list = new ArrayList();
        MonoQueue mq = new MonoQueue();
        for (int i = 0; i < k; i ++) mq.push(nums[i]);
        list.add(mq.front());
        System.out.println(mq.queue);
        for (int i = k; i < nums.length; i ++) {
            mq.pop(nums[i-k]);
            mq.push(nums[i]);
            list.add(mq.front());
            // System.out.println(mq.queue);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}