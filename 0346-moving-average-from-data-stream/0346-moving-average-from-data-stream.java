class MovingAverage {
    int capacity;
    int sum;
    int size;
    Queue<Integer> q;

    public MovingAverage(int size) {
        this.capacity = size;
        this.sum = 0;
        this.size = 0;
        this.q = new LinkedList();
    }
    
    public double next(int val) {
        if (size < capacity) {
            q.offer(val);
            sum += val;
            size ++;
            return (double)sum / (double)size;
        }
        int r = q.poll();
        sum -= r;
        sum += val;
        q.offer(val);
        return (double)sum / (double)size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */