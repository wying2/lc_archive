class MyStack {
    Queue<Integer> in;
    Queue<Integer> out;
    int last;

    public MyStack() {
        this.in = new LinkedList<>();
        this.out = new LinkedList<>();
        last = 0;
    }
    
    public void push(int x) {
        this.in.add(x);
        last = x;
    }
    
    public int pop() {
        while(in.size() > 1) {
            last = in.remove();
            out.add(last);
        }
            
        int res = in.remove();
        this.in = this.out;
        this.out = new LinkedList<>();
        return res;
    }
    
    public int top() {
        return last;
    }
    
    public boolean empty() {
        return in.isEmpty();
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