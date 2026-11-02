class Solution {
    public int[] asteroidCollision(int[] ass) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<ass.length;i++){
            if(ass[i]>0){
                stack.push(ass[i]);
            }
            else if(ass[i]<0){
                while(!stack.isEmpty() && stack.peek()>0 && ass[i]<0){
                    if(stack.peek()< -ass[i]){
                        stack.pop();
                        continue;

                    }
                    else if(stack.peek()==-ass[i]){
                        stack.pop();
                        ass[i]=0;
                        break;
                    }
                    else{
                        ass[i]=0;
                        break;

                    }
                }
                if(ass[i]<0){
                    stack.push(ass[i]);
                }
        }}
        int array[]=new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            array[i] = stack.pop();
        }
        
        return array;
    }
}