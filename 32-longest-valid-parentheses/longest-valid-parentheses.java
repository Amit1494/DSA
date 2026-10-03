class Solution {
    public int longestValidParentheses(String s) {
        return Math.max(forward(s),reverse(s));
    }
    public int forward(String s){
        int open=0;
        int close=0;
        int maxr=0;
        int temp=0;

        for(char ch:s.toCharArray()){
            
            if(close>open){
                close=0;
                open=0;
                temp=0;
            }
            if(ch=='('){
                open++;
            }
            else if(ch==')'){
                close++;
            }
            if(open==close){
                maxr=Math.max(maxr,open+close);
            }
        }
        return maxr;

    }
    public int reverse(String s){
        int open=0;
        int close=0;
        int maxr=0;
        int temp=0;

        for(int i=s.length()-1;i>=0;i--){
            
            if(close<open){
                close=0;
                open=0;
                temp=0;
            }
            if(s.charAt(i)=='('){
                open++;
            }
            else if(s.charAt(i)==')'){
                close++;
            }
            if(open==close){
                maxr=Math.max(maxr,open+close);
            }
        }
        return maxr;
        
    }
}