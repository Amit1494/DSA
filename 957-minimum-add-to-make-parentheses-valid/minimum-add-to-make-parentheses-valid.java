class Solution {
    public int minAddToMakeValid(String s) {
        int close=0; 
        Stack<Character> str=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                str.push(ch);
            }
            else if(ch==')'){
                if(str.isEmpty()) {
                    close++;
                }

                else if(str.peek()=='('){
                    str.pop();
                }
                
            }
        }
        return str.size()+close;
        
    }
}