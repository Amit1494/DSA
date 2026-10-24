class MinStack {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    Stack<Pair> stack;

    public MinStack() {
        stack=new Stack<>();
    }
    
    public void push(int value) {
        if(stack.isEmpty()){
            stack.push(new Pair(value,value));
        }
        else{
            int mini=Math.min(value,stack.peek().second);
            stack.push(new Pair(value,mini));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().first;

    }
    
    public int getMin() {
        return stack.peek().second;
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