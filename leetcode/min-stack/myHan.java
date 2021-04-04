class MinStack {
    private class Item {
        public int v, m;
        public Item(int v, int m) {
            this.v = v;
            this.m = m;
        }
    }
    private Stack<Item> stk;
    /** initialize your data structure here. */
    public MinStack() {
        stk = new Stack();
    }
    
    public void push(int val) {
        if(0 < stk.size())
            stk.push(new Item(val, Math.min(val, Math.min(val, getMin()))));
        else
            stk.push(new Item(val, Math.min(val, val)));
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek().v;
    }
    
    public int getMin() {
        return stk.peek().m;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */