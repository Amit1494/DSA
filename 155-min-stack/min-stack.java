class MinStack {
    long minimum=Integer.MAX_VALUE;
    // static class Pair{
    //     int first;
    //     int second;
    //     Pair(int first,int second){
    //         this.first=first;
    //         this.second=second;
    //     }
    // }
    Stack<Long> stack;

    public MinStack() {
        stack=new Stack<>();
    }
    
    public void push(int value) {
        long val=value;
        if(stack.isEmpty()){
            minimum=value;
            stack.push(val);
        }
        else if(value<minimum){
            stack.push(2*val-minimum);
            minimum=val;

        }
        else{
        stack.push(val);
    }}
    
    public void pop() {
        if(stack.isEmpty())return;
        long n=stack.peek();
        stack.pop();
        if(n<minimum){
            minimum=2*minimum-n;
        }
    }
    
    public int top() {
        long n = stack.peek();

        if (n < minimum) {
            return (int) minimum;
        }

        return (int) n;

    }
    
    public int getMin() {
        return (int)minimum;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */