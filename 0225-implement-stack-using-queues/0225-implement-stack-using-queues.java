class MyStack {
    Queue<Integer> q;
    int last;

    public MyStack() {
        this.q = new LinkedList<>();
        last = 0;
    }
    
    public void push(int x) {
        this.q.add(x);
        last = x;
    }
    
    public int pop() {
        int n = q.size() -1;
        while (n >= 1) {
            last = q.remove();
            q.add(last);
            n --;
        }
        return q.remove();
    }
    
    public int top() {
        return last;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */