class MinStack {

    Deque<Integer> dq;
    Deque<Integer> minDq;

    public MinStack() {
        dq = new ArrayDeque();
        minDq = new ArrayDeque();
    }
    
    public void push(int val) {
        dq.addLast(val);
        if (!minDq.isEmpty()) {
            minDq.addLast(Math.min(minDq.peekLast(), val));
        } else {
            minDq.addLast(val);
        }
    }
    
    public void pop() {
        dq.removeLast();
        minDq.removeLast();
    }
    
    public int top() {
        return dq.getLast();
    }
    
    public int getMin() {
        return minDq.getLast();
    }
}
